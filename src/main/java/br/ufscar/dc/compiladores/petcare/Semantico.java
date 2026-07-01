package br.ufscar.dc.compiladores.petcare;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * Analisador semântico do PetCareScript.
 *
 * Esta etapa percorre a árvore sintática gerada pelo ANTLR e aplica regras
 * de consistência que não são garantidas apenas pela gramática.
 *
 * O analisador separa dois tipos de diagnóstico:
 * - erros: impedem a geração do HTML;
 * - warnings: avisam o usuário, mas não bloqueiam a compilação.
 *
 * Verificações de erro implementadas:
 * 1. Cada pet deve declarar exatamente uma espécie.
 * 2. Cada pet deve declarar exatamente uma idade.
 * 3. Idade não pode ser maior que 80.
 * 4. Não pode repetir vacina com o mesmo nome no mesmo pet.
 * 5. Horários da rotina devem estar entre 00:00 e 23:59.
 * 6. Não pode repetir horário na rotina do mesmo pet.
 * 7. Duração de remédio deve ser maior que zero.
 * 8. Cada pet deve ter pelo menos uma vacina, remédio ou rotina.
 * 9. Datas de vacina devem representar datas reais.
 *
 * Warnings implementados:
 * 1. Pet com mais de 15 anos recebe aviso de terceira idade.
 * 2. Vacina registrada em ano diferente do ano atual recebe aviso para revisão.
 */
public class Semantico extends PetCareBaseVisitor<Void> {
    private final List<String> erros = new ArrayList<>();
    private final List<String> warnings = new ArrayList<>();

    public boolean temErros() {
        return !erros.isEmpty();
    }

    public boolean temWarnings() {
        return !warnings.isEmpty();
    }

    public List<String> getErros() {
        return erros;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    // Tabela para guardar as vacinas globais
    class InfoVacina {
        String nome;
        String especie;
        int idadeMeses;
        int validadeMeses;
    }

    // A chave é o nomeVacina_especie
    private final Map<String, InfoVacina> vacinasGlobais = new HashMap<>();

    @Override
    public Void visitDeclVacina(PetCareParser.DeclVacinaContext ctx) {
        String nomeVacina = Util.removeAspas(ctx.STRING().getText()).toLowerCase();
        String especie = null;
        int idadeMeses = 0;
        int validadeMeses = 0;

        int qtdEspecie = 0, qtdIdade = 0, qtdValidade = 0;

        for (PetCareParser.CampoDeclVacinaContext campo : ctx.campoDeclVacina()) {
            if (campo.especie() != null) {
                qtdEspecie++;
                especie = campo.especie().ESPECIE().getText();
            } else if (campo.declIdade() != null) {
                qtdIdade++;
                int num = Integer.parseInt(campo.declIdade().NUM().getText());
                // Converte tudo para meses para facilitar o cálculo
                idadeMeses = campo.declIdade().TEMPO().getText().startsWith("ano") ? num * 12 : num;
            } else if (campo.declValidade() != null) {
                qtdValidade++;
                int num = Integer.parseInt(campo.declValidade().NUM().getText());
                validadeMeses = campo.declValidade().TEMPO().getText().startsWith("ano") ? num * 12 : num;
            }
        }

        if (qtdEspecie == 0) adicionarErro(ctx.start.getLine(), "declaracao da vacina '" + nomeVacina + "' deve especificar a especie");
        if (qtdIdade == 0) adicionarErro(ctx.start.getLine(), "declaracao da vacina '" + nomeVacina + "' deve especificar a idade");
        if (qtdValidade == 0) adicionarErro(ctx.start.getLine(), "declaracao da vacina '" + nomeVacina + "' deve especificar a validade");

        if (especie != null) {
            String chave = nomeVacina + "_" + especie;
            if (vacinasGlobais.containsKey(chave)) {
                adicionarErro(ctx.start.getLine(), "vacina '" + nomeVacina + "' ja declarada para a especie '" + especie + "'");
            } else {
                InfoVacina info = new InfoVacina();
                info.nome = nomeVacina;
                info.especie = especie;
                info.idadeMeses = idadeMeses;
                info.validadeMeses = validadeMeses;
                vacinasGlobais.put(chave, info);
            }
        }
        return null;
    }

    @Override
    public Void visitPet(PetCareParser.PetContext ctx) {
        String nomePet = Util.removeAspas(ctx.STRING().getText());

        int qtdEspecie = 0;
        int qtdIdade = 0;
        int qtdAcoes = 0;

        String especiePet = null;

        // Analisa a espécie antes de checar as vacinas
        for (PetCareParser.CampoPetContext campo : ctx.campoPet()) {
            if (campo.especie() != null) {
                especiePet = campo.especie().ESPECIE().getText();
            }
        }

        Set<String> vacinas = new HashSet<>();
        Set<String> horarios = new HashSet<>();

        for (PetCareParser.CampoPetContext campo : ctx.campoPet()) {
            if (campo.especie() != null) {
                qtdEspecie++;
            }

            if (campo.idade() != null) {
                qtdIdade++;
                int idade = Integer.parseInt(campo.idade().NUM().getText());

                if (idade > 80) {
                    adicionarErro(campo.idade().start.getLine(),
                            "idade do pet '" + nomePet + "' parece invalida; valor maximo permitido e 80");
                } else if (idade > 15) {
                    adicionarWarning(campo.idade().start.getLine(),
                            "o pet '" + nomePet + "' esta na terceira idade; recomenda-se checagem veterinaria frequente");
                }
            }

            if (campo.vacina() != null) {
                qtdAcoes++;
                String nomeVacinaOriginal = Util.removeAspas(campo.vacina().STRING().getText());
                String nomeVacina = nomeVacinaOriginal.toLowerCase();

                if (vacinas.contains(nomeVacina)) {
                    adicionarErro(campo.vacina().start.getLine(), "vacina '" + nomeVacina + "' repetida para o pet '" + nomePet + "'");
                } else {
                    vacinas.add(nomeVacina);
                }

                String dataString = campo.vacina().DATA().getText();
                validarData(dataString, campo.vacina().start.getLine());

                // Checa do ano da vacina
                int anoVacina = anoDaData(dataString);
                if (anoVacina != LocalDate.now().getYear()) {
                    adicionarWarning(campo.vacina().start.getLine(),
                            "a vacina '" + nomeVacinaOriginal + "' de '" + nomePet + "' não é deste ano (" + anoVacina + "); verifique a validade no dashboard");
                }

                if (especiePet != null) {
                    String chave = nomeVacina + "_" + especiePet;
                    if (!vacinasGlobais.containsKey(chave)) {
                        adicionarErro(campo.vacina().start.getLine(), "vacina '" + nomeVacinaOriginal + "' não está registrada para a especie '" + especiePet + "'");
                    }
                }
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

    private void adicionarWarning(int linha, String mensagem) {
        warnings.add("Linha " + linha + ": Aviso: " + mensagem);
    }

    private boolean horaValida(String hora) {
        String[] partes = hora.split(":");
        int h = Integer.parseInt(partes[0]);
        int m = Integer.parseInt(partes[1]);
        return h >= 0 && h <= 23 && m >= 0 && m <= 59;
    }

    private void validarData(String data, int linha) {
        try {
            LocalDate.parse(data);
        } catch (DateTimeParseException e) {
            adicionarErro(linha, "data invalida '" + data + "'");
        }
    }

    private int anoDaData(String data) {
        return Integer.parseInt(data.substring(0, 4));
    }
}