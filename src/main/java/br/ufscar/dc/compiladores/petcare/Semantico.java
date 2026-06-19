package br.ufscar.dc.compiladores.petcare;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Analisador semântico do PetCareScript.
 *
 * Verificações implementadas:
 * 1. Cada pet deve declarar exatamente uma especie.
 * 2. Cada pet deve declarar exatamente uma idade.
 * 3. Idade não pode ser negativa e nem maior que 80.
 * 4. Não pode repetir vacina com o mesmo nome no mesmo pet.
 * 5. Horários da rotina devem estar entre 00:00 e 23:59.
 * 6. Não pode repetir horário na rotina do mesmo pet.
 * 7. Duração de remédio deve ser maior que zero.
 * 8. Cada pet deve ter pelo menos uma vacina, remédio ou rotina.
 */
public class Semantico extends PetCareBaseVisitor<Void> {
    private final List<String> erros = new ArrayList<>();

    public boolean temErros() {
        return !erros.isEmpty();
    }

    public List<String> getErros() {
        return erros;
    }

    @Override
    public Void visitPet(PetCareParser.PetContext ctx) {
        String nomePet = Util.removeAspas(ctx.STRING().getText());

        int qtdEspecie = 0;
        int qtdIdade = 0;
        int qtdAcoes = 0;

        Set<String> vacinas = new HashSet<>();
        Set<String> horarios = new HashSet<>();

        for (PetCareParser.CampoPetContext campo : ctx.campoPet()) {
            if (campo.especie() != null) {
                qtdEspecie++;
            }

            if (campo.idade() != null) {
                qtdIdade++;
                int idade = Integer.parseInt(campo.idade().NUM().getText());

                if (idade < 0) {
                    adicionarErro(campo.idade().start.getLine(),
                            "idade do pet '" + nomePet + "' nao pode ser negativa");
                }

                if (idade > 80) {
                    adicionarErro(campo.idade().start.getLine(),
                            "idade do pet '" + nomePet + "' parece invalida; valor maximo permitido e 80");
                }
            }

            if (campo.vacina() != null) {
                qtdAcoes++;
                String nomeVacina = Util.removeAspas(campo.vacina().STRING().getText()).toLowerCase();

                if (vacinas.contains(nomeVacina)) {
                    adicionarErro(campo.vacina().start.getLine(),
                            "vacina '" + nomeVacina + "' repetida para o pet '" + nomePet + "'");
                } else {
                    vacinas.add(nomeVacina);
                }

                validarData(campo.vacina().DATA().getText(), campo.vacina().start.getLine());
            }

            if (campo.remedio() != null) {
                qtdAcoes++;
                int dias = Integer.parseInt(campo.remedio().NUM().getText());

                if (dias <= 0) {
                    adicionarErro(campo.remedio().start.getLine(),
                            "duracao do remedio deve ser maior que zero");
                }
            }

            if (campo.rotina() != null) {
                qtdAcoes++;

                for (PetCareParser.ItemRotinaContext item : campo.rotina().itemRotina()) {
                    String hora = item.HORA().getText();

                    if (!horaValida(hora)) {
                        adicionarErro(item.start.getLine(),
                                "horario invalido '" + hora + "'. Use valores entre 00:00 e 23:59");
                    }

                    if (horarios.contains(hora)) {
                        adicionarErro(item.start.getLine(),
                                "horario '" + hora + "' repetido na rotina do pet '" + nomePet + "'");
                    } else {
                        horarios.add(hora);
                    }
                }
            }
        }

        if (qtdEspecie == 0) {
            adicionarErro(ctx.start.getLine(), "pet '" + nomePet + "' deve declarar especie");
        }

        if (qtdEspecie > 1) {
            adicionarErro(ctx.start.getLine(), "pet '" + nomePet + "' declarou especie mais de uma vez");
        }

        if (qtdIdade == 0) {
            adicionarErro(ctx.start.getLine(), "pet '" + nomePet + "' deve declarar idade");
        }

        if (qtdIdade > 1) {
            adicionarErro(ctx.start.getLine(), "pet '" + nomePet + "' declarou idade mais de uma vez");
        }

        if (qtdAcoes == 0) {
            adicionarErro(ctx.start.getLine(),
                    "pet '" + nomePet + "' deve possuir pelo menos uma vacina, remedio ou rotina");
        }

        return null;
    }

    private void adicionarErro(int linha, String mensagem) {
        erros.add("Linha " + linha + ": " + mensagem);
    }

    private boolean horaValida(String hora) {
        String[] partes = hora.split(":");
        int h = Integer.parseInt(partes[0]);
        int m = Integer.parseInt(partes[1]);
        return h >= 0 && h <= 23 && m >= 0 && m <= 59;
    }

    private void validarData(String data, int linha) {
        String[] partes = data.split("-");
        int mes = Integer.parseInt(partes[1]);
        int dia = Integer.parseInt(partes[2]);

        if (mes < 1 || mes > 12) {
            adicionarErro(linha, "data invalida '" + data + "': mes deve estar entre 01 e 12");
        }

        if (dia < 1 || dia > 31) {
            adicionarErro(linha, "data invalida '" + data + "': dia deve estar entre 01 e 31");
        }
    }
}
