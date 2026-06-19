package br.ufscar.dc.compiladores.petcare;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;

/**
 * Captura erros léxicos e sintáticos em formato simples.
 */
public class ErroSintatico extends BaseErrorListener {
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

        if (!erro) {
            erro = true;
            mensagem = "Linha " + line + ": erro sintatico proximo a posicao " + charPositionInLine;
        }
    }

    public boolean temErro() {
        return erro;
    }

    public String getMensagem() {
        return mensagem;
    }
}
