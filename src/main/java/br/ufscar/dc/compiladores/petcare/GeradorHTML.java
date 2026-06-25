package br.ufscar.dc.compiladores.petcare;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Geração de código do PetCareScript.
 *
 * Esta classe percorre a árvore sintática e transforma o programa de entrada
 * em uma página HTML. A versão atual gera um dashboard visual com Bootstrap,
 * cards para cada pet, ícones por espécie, tabelas estilizadas e marcação de
 * vacinas que não pertencem ao ano atual.
 */
public class GeradorHTML extends PetCareBaseVisitor<String> {
    private final StringBuilder saida = new StringBuilder();
    private final List<String> warnings;

    /**
     * Construtor usado quando a geração precisa exibir warnings no HTML.
     */
    public GeradorHTML(List<String> warnings) {
        this.warnings = warnings;
    }

    /**
     * Construtor padrão mantido para compatibilidade com a versão anterior.
     */
    public GeradorHTML() {
        this.warnings = new ArrayList<>();
    }

    // Monta o HTML completo: cabeçalho, navbar, painel de warnings e cards dos pets.
    @Override
    public String visitPrograma(PetCareParser.ProgramaContext ctx) {
        gerarCabecalho();

        saida.append("<body>\n");
        saida.append("<nav class=\"navbar navbar-expand-lg navbar-dark bg-primary shadow-sm\">\n");
        saida.append("  <div class=\"container\">\n");
        saida.append("    <span class=\"navbar-brand fw-bold\">🐾 PetCareScript</span>\n");
        saida.append("  </div>\n");
        saida.append("</nav>\n");

        saida.append("<main class=\"container my-4\">\n");
        saida.append("<section class=\"mb-4 text-center\">\n");
        saida.append("  <h1 class=\"display-5 fw-bold\">Dashboard de Cuidados dos Pets</h1>\n");
        saida.append("  <p class=\"lead text-muted\">Relatório gerado automaticamente pelo compilador PetCareScript.</p>\n");
        saida.append("</section>\n");

        gerarPainelWarnings();

        saida.append("<div class=\"row g-4\">\n");
        for (PetCareParser.PetContext pet : ctx.pet()) {
            gerarCardPet(pet);
        }
        saida.append("</div>\n");

        saida.append("</main>\n");
        saida.append("<footer class=\"text-center text-muted py-4\">\n");
        saida.append("  <small>Gerado por PetCareScript • Construção de Compiladores</small>\n");
        saida.append("</footer>\n");
        saida.append("</body>\n");
        saida.append("</html>\n");

        return saida.toString();
    }

    // Gera a tag <head> com Bootstrap via CDN e estilos complementares.
    private void gerarCabecalho() {
        saida.append("<!DOCTYPE html>\n");
        saida.append("<html lang=\"pt-BR\">\n");
        saida.append("<head>\n");
        saida.append("  <meta charset=\"UTF-8\">\n");
        saida.append("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        saida.append("  <title>PetCareScript Dashboard</title>\n");
        saida.append("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
        saida.append("  <style>\n");
        saida.append("    body { background: #f5f7fb; }\n");
        saida.append("    .pet-icon { font-size: 3rem; line-height: 1; }\n");
        saida.append("    .card { border: none; border-radius: 1rem; }\n");
        saida.append("    .card-header { border-top-left-radius: 1rem !important; border-top-right-radius: 1rem !important; }\n");
        saida.append("    .section-title { font-size: 1rem; font-weight: 700; margin-top: 1rem; margin-bottom: .5rem; }\n");
        saida.append("    .badge-vencida { background-color: #dc3545; }\n");
        saida.append("    .badge-em-dia { background-color: #198754; }\n");
        saida.append("  </style>\n");
        saida.append("</head>\n");
    }

    // Exibe os avisos semânticos no topo do dashboard.
    private void gerarPainelWarnings() {
        if (warnings == null || warnings.isEmpty()) {
            saida.append("<div class=\"alert alert-success shadow-sm\" role=\"alert\">\n");
            saida.append("  ✅ Compilação concluída sem avisos semânticos.\n");
            saida.append("</div>\n");
            return;
        }

        saida.append("<div class=\"alert alert-warning shadow-sm\" role=\"alert\">\n");
        saida.append("  <h4 class=\"alert-heading\">⚠️ Avisos semânticos</h4>\n");
        saida.append("  <ul class=\"mb-0\">\n");
        for (String warning : warnings) {
            saida.append("    <li>").append(Util.escapeHtml(warning)).append("</li>\n");
        }
        saida.append("  </ul>\n");
        saida.append("</div>\n");
    }

    // Extrai os dados de um pet e monta um card Bootstrap.
    private void gerarCardPet(PetCareParser.PetContext ctx) {
        String nome = Util.escapeHtml(Util.removeAspas(ctx.STRING().getText()));
        String especie = "";
        String idade = "";
        String tutor = "";

        Map<Integer, List<String>> vacinasPorAno = new TreeMap<>();
        List<String> remedios = new ArrayList<>();
        List<String> rotina = new ArrayList<>();

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

            if (campo.vacina() != null) {
                String nomeVacina = Util.escapeHtml(Util.removeAspas(campo.vacina().STRING().getText()));
                String data = campo.vacina().DATA().getText();
                int ano = Integer.parseInt(data.substring(0, 4));
                boolean vencida = ano != LocalDate.now().getYear();

                String linha = "<tr>"
                        + "<td>" + nomeVacina + "</td>"
                        + "<td>" + data + "</td>"
                        + "<td>" + statusVacina(vencida) + "</td>"
                        + "</tr>\n";

                vacinasPorAno.computeIfAbsent(ano, chave -> new ArrayList<>()).add(linha);
            }

            if (campo.remedio() != null) {
                String nomeRemedio = Util.escapeHtml(Util.removeAspas(campo.remedio().STRING(0).getText()));
                String dose = Util.escapeHtml(Util.removeAspas(campo.remedio().STRING(1).getText()));
                String dias = campo.remedio().NUM().getText();

                remedios.add("<tr>"
                        + "<td>" + nomeRemedio + "</td>"
                        + "<td>" + dose + "</td>"
                        + "<td>" + dias + " dias</td>"
                        + "</tr>\n");
            }

            if (campo.rotina() != null) {
                for (PetCareParser.ItemRotinaContext item : campo.rotina().itemRotina()) {
                    String hora = item.HORA().getText();
                    String atividade = Util.escapeHtml(Util.removeAspas(item.STRING().getText()));

                    rotina.add("<tr>"
                            + "<td><span class=\"badge text-bg-primary\">" + hora + "</span></td>"
                            + "<td>" + atividade + "</td>"
                            + "</tr>\n");
                }
            }
        }

        saida.append("<div class=\"col-12 col-lg-6\">\n");
        saida.append("  <div class=\"card shadow-sm h-100\">\n");
        saida.append("    <div class=\"card-header bg-white d-flex align-items-center gap-3\">\n");
        saida.append("      <div class=\"pet-icon\">").append(iconeEspecie(especie)).append("</div>\n");
        saida.append("      <div>\n");
        saida.append("        <h2 class=\"h4 mb-0\">").append(nome).append("</h2>\n");
        saida.append("        <span class=\"text-muted text-capitalize\">").append(especie).append("</span>\n");
        saida.append("      </div>\n");
        saida.append("    </div>\n");
        saida.append("    <div class=\"card-body\">\n");
        saida.append("      <div class=\"row mb-3\">\n");
        saida.append("        <div class=\"col\"><strong>Idade:</strong> ").append(idade).append(" anos</div>\n");
        if (!tutor.isEmpty()) {
            saida.append("        <div class=\"col\"><strong>Tutor:</strong> ").append(tutor).append("</div>\n");
        }
        saida.append("      </div>\n");

        gerarTabelaVacinas(vacinasPorAno);
        gerarTabelaRemedios(remedios);
        gerarTabelaRotina(rotina);

        saida.append("    </div>\n");
        saida.append("  </div>\n");
        saida.append("</div>\n");
    }

    // Gera tabelas de vacinas agrupadas por ano.
    private void gerarTabelaVacinas(Map<Integer, List<String>> vacinasPorAno) {
        if (vacinasPorAno.isEmpty()) {
            return;
        }

        saida.append("<div class=\"section-title\">💉 Vacinas por ano</div>\n");
        for (Map.Entry<Integer, List<String>> entrada : vacinasPorAno.entrySet()) {
            saida.append("<h6 class=\"mt-3 text-muted\">Ano ").append(entrada.getKey()).append("</h6>\n");
            saida.append("<div class=\"table-responsive\">\n");
            saida.append("<table class=\"table table-sm table-striped align-middle\">\n");
            saida.append("<thead><tr><th>Vacina</th><th>Data</th><th>Status</th></tr></thead>\n");
            saida.append("<tbody>\n");
            for (String linha : entrada.getValue()) {
                saida.append(linha);
            }
            saida.append("</tbody>\n");
            saida.append("</table>\n");
            saida.append("</div>\n");
        }
    }

    // Gera a tabela de remédios cadastrados.
    private void gerarTabelaRemedios(List<String> remedios) {
        if (remedios.isEmpty()) {
            return;
        }

        saida.append("<div class=\"section-title\">💊 Remédios</div>\n");
        saida.append("<div class=\"table-responsive\">\n");
        saida.append("<table class=\"table table-sm table-striped align-middle\">\n");
        saida.append("<thead><tr><th>Remédio</th><th>Dose</th><th>Duração</th></tr></thead>\n");
        saida.append("<tbody>\n");
        for (String linha : remedios) {
            saida.append(linha);
        }
        saida.append("</tbody>\n");
        saida.append("</table>\n");
        saida.append("</div>\n");
    }

    // Gera a tabela de rotina diária.
    private void gerarTabelaRotina(List<String> rotina) {
        if (rotina.isEmpty()) {
            return;
        }

        saida.append("<div class=\"section-title\">🕒 Rotina diária</div>\n");
        saida.append("<div class=\"table-responsive\">\n");
        saida.append("<table class=\"table table-sm table-hover align-middle\">\n");
        saida.append("<thead><tr><th>Horário</th><th>Atividade</th></tr></thead>\n");
        saida.append("<tbody>\n");
        for (String linha : rotina) {
            saida.append(linha);
        }
        saida.append("</tbody>\n");
        saida.append("</table>\n");
        saida.append("</div>\n");
    }

    // Retorna o selo visual de status da vacina.
    private String statusVacina(boolean vencida) {
        if (vencida) {
            return "<span class=\"badge badge-vencida\">[VENCIDA]</span>";
        }
        return "<span class=\"badge badge-em-dia\">EM DIA</span>";
    }

    // Escolhe um ícone de acordo com a espécie declarada.
    private String iconeEspecie(String especie) {
        switch (especie) {
            case "cachorro":
                return "🐶";
            case "gato":
                return "🐱";
            case "passaro":
                return "🐦";
            case "peixe":
                return "🐟";
            case "coelho":
                return "🐰";
            default:
                return "🐾";
        }
    }
}
