package br.ufscar.dc.compiladores.petcare;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;

/**
 * Captura erros léxicos e sintáticos em formato simples.
 */
public class ErroSintatico extends BaseErrorListener {
    // Flag de controle para garantir que apenas o primeiro erro seja armazenado
    private boolean erro = false;
    private String mensagem = "";

    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer,
            Object offendingSymbol,
            int line,
            int charPositionInLine,
            String msg,
            RecognitionException e) {

        // Se um erro já foi capturado, ignora erros subsequentes
        if (!erro) {
            erro = true;
            mensagem = "Linha " + line + ": erro sintatico proximo a posicao " + charPositionInLine;
        }
    }

    // Retorna verdadeiro se algum erro léxico ou sintático foi detectado durante o parsing
    public boolean temErro() {
        return erro;
    }

    // Retorna a mensagem de erro formatada
    public String getMensagem() {
        return mensagem;
    }
}
