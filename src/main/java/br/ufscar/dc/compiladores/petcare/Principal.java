package br.ufscar.dc.compiladores.petcare;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Classe principal do compilador PetCareScript.
 *
 * Uso:
 * java -jar target/PetCareScript.jar entrada.pet saida.html
 */
public class Principal {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: java -jar target/PetCareScript.jar <entrada.pet> <saida.html>");
            return;
        }

        String arquivoEntrada = args[0];
        String arquivoSaida = args[1];

        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(
                Paths.get(arquivoSaida), StandardCharsets.UTF_8))) {

            PetCareLexer lexer = new PetCareLexer(CharStreams.fromFileName(arquivoEntrada, StandardCharsets.UTF_8));
            ErroSintatico errorListener = new ErroSintatico();
            lexer.removeErrorListeners();
            lexer.addErrorListener(errorListener);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            PetCareParser parser = new PetCareParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);

            PetCareParser.ProgramaContext arvore = parser.programa();

            if (errorListener.temErro()) {
                pw.println(errorListener.getMensagem());
                pw.println("Fim da compilacao");
                return;
            }

            Semantico semantico = new Semantico();
            semantico.visitPrograma(arvore);

            if (semantico.temErros()) {
                for (String erro : semantico.getErros()) {
                    pw.println(erro);
                }
                pw.println("Fim da compilacao");
                return;
            }

            GeradorHTML gerador = new GeradorHTML();
            String html = gerador.visitPrograma(arvore);
            pw.println(html);

        } catch (IOException e) {
            System.err.println("Erro ao ler/escrever arquivo: " + e.getMessage());
        }
    }
}
