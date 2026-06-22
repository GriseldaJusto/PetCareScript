package br.ufscar.dc.compiladores.petcare;

/**
 * Funções auxiliares usadas pelo semântico e pelo gerador de HTML.
 */
public class Util {
    // Remove as aspas duplas do início e do fim de uma string
    public static String removeAspas(String texto) {
        if (texto == null || texto.length() < 2) {
            return texto;
        }
        return texto.substring(1, texto.length() - 1);
    }

    // Substitui caracteres especiais do HTML por suas identidades para evitar falhas de formatação
    public static String escapeHtml(String texto) {
        if (texto == null) {
            return "";
        }

        return texto
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
