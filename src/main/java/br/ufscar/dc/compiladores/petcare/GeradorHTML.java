package br.ufscar.dc.compiladores.petcare;

/**
 * Geração de código: transforma o script em uma página HTML.
 * Implementa o padrão Visitor para percorrer os nós da AST e concatenar strings de marcação HTML.
 */
public class GeradorHTML extends PetCareBaseVisitor<String> {
    private final StringBuilder saida = new StringBuilder();

    // Monta o cabeçalho do HTML, insere o CSS e itera sobre todos os pets declarados no arquivo
    @Override
    public String visitPrograma(PetCareParser.ProgramaContext ctx) {
        saida.append("<!DOCTYPE html>\n");
        saida.append("<html lang=\"pt-BR\">\n");
        saida.append("<head>\n");
        saida.append("  <meta charset=\"UTF-8\">\n");
        saida.append("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        saida.append("  <title>PetCareScript</title>\n");
        saida.append("  <style>\n");
        saida.append("    body { font-family: Arial, sans-serif; margin: 40px; background: #f7f7f7; }\n");
        saida.append("    .pet { background: white; padding: 20px; margin-bottom: 20px; border-radius: 12px; box-shadow: 0 2px 8px #ccc; }\n");
        saida.append("    h1 { color: #333; }\n");
        saida.append("    h2 { color: #6b3fa0; }\n");
        saida.append("    table { border-collapse: collapse; width: 100%; margin-top: 10px; }\n");
        saida.append("    th, td { border: 1px solid #ddd; padding: 8px; }\n");
        saida.append("    th { background: #eee; }\n");
        saida.append("  </style>\n");
        saida.append("</head>\n");
        saida.append("<body>\n");
        saida.append("<h1>Relatório de Cuidados dos Pets</h1>\n");

        // Percorre cada bloco 'pet' e extrai os dados
        for (PetCareParser.PetContext pet : ctx.pet()) {
            gerarPet(pet);
        }

        saida.append("</body>\n");
        saida.append("</html>\n");

        return saida.toString();
    }

    // Extrai os dados de um pet e monta o card no HTML
    private void gerarPet(PetCareParser.PetContext ctx) {
        // Remove as aspas do nome do pet
        String nome = Util.escapeHtml(Util.removeAspas(ctx.STRING().getText()));

        String especie = "";
        String idade = "";
        String tutor = "";

        // Agrupa as listas de registros
        StringBuilder vacinas = new StringBuilder();
        StringBuilder remedios = new StringBuilder();
        StringBuilder rotina = new StringBuilder();

        // Itera sobre todos os campos declarados dentro do bloco do pet
        for (PetCareParser.CampoPetContext campo : ctx.campoPet()) {
            if (campo.especie() != null) {
                especie = campo.especie().ESPECIE().getText();
            }

            if (campo.idade() != null) {
                idade = campo.idade().NUM().getText();
            }

            if (campo.tutor() != null) {
                tutor = Util.escapeHtml(Util.removeAspas(campo.tutor().STRING().getText()));
            }

            // Se tiver uma vacina, adiciona uma nova linha na tabela de vacinas
            if (campo.vacina() != null) {
                String nomeVacina = Util.escapeHtml(Util.removeAspas(campo.vacina().STRING().getText()));
                String data = campo.vacina().DATA().getText();
                vacinas.append("<tr><td>").append(nomeVacina).append("</td><td>").append(data).append("</td></tr>\n");
            }

            // Se tiver um remédio, adiciona uma nova linha na tabela de remédios
            if (campo.remedio() != null) {
                String nomeRemedio = Util.escapeHtml(Util.removeAspas(campo.remedio().STRING(0).getText()));
                String dose = Util.escapeHtml(Util.removeAspas(campo.remedio().STRING(1).getText()));
                String dias = campo.remedio().NUM().getText();
                remedios.append("<tr><td>").append(nomeRemedio).append("</td><td>").append(dose)
                        .append("</td><td>").append(dias).append(" dias</td></tr>\n");
            }

            // Se tiver rotina, adiciona os horários e itens registrados
            if (campo.rotina() != null) {
                for (PetCareParser.ItemRotinaContext item : campo.rotina().itemRotina()) {
                    String hora = item.HORA().getText();
                    String atividade = Util.escapeHtml(Util.removeAspas(item.STRING().getText()));
                    rotina.append("<tr><td>").append(hora).append("</td><td>").append(atividade).append("</td></tr>\n");
                }
            }
        }

        // Montagem da interface final
        saida.append("<section class=\"pet\">\n");
        saida.append("<h2>").append(nome).append("</h2>\n");
        saida.append("<p><strong>Espécie:</strong> ").append(especie).append("</p>\n");
        saida.append("<p><strong>Idade:</strong> ").append(idade).append("</p>\n");

        if (!tutor.isEmpty()) {
            saida.append("<p><strong>Tutor:</strong> ").append(tutor).append("</p>\n");
        }

        // Monta as tabelas caso registrado
        if (vacinas.length() > 0) {
            saida.append("<h3>Vacinas</h3>\n");
            saida.append("<table><tr><th>Vacina</th><th>Data</th></tr>\n");
            saida.append(vacinas);
            saida.append("</table>\n");
        }

        if (remedios.length() > 0) {
            saida.append("<h3>Remédios</h3>\n");
            saida.append("<table><tr><th>Remédio</th><th>Dose</th><th>Duração</th></tr>\n");
            saida.append(remedios);
            saida.append("</table>\n");
        }

        if (rotina.length() > 0) {
            saida.append("<h3>Rotina</h3>\n");
            saida.append("<table><tr><th>Horário</th><th>Atividade</th></tr>\n");
            saida.append(rotina);
            saida.append("</table>\n");
        }

        saida.append("</section>\n");
    }
}
