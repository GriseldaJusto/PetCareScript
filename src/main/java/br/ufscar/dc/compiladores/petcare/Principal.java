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
 * Responsável por orquestrar todo o pipeline de compilação:
 * Análise Léxica -> Análise Sintática -> Análise Semântica -> Geração de HTML.
 *
 * Uso:
 * java -jar target/PetCareScript.jar entrada.pet saida.html
 */
public class Principal {
    public static void main(String[] args) {
        // Valida se os argumentos de entrada e saída foram passados corretamente
        if (args.length != 2) {
            System.err.println("Uso: java -jar target/PetCareScript.jar <entrada.pet> <saida.html>");
            return;
        }

        String arquivoEntrada = args[0];    
        String arquivoSaida = args[1];

        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(
                Paths.get(arquivoSaida), StandardCharsets.UTF_8))) {

            // Faz a análise léxica, ele lê o arquivo-fonte e converte numa sequência de tokens
            PetCareLexer lexer = new PetCareLexer(CharStreams.fromFileName(arquivoEntrada, StandardCharsets.UTF_8));

            // Substitui o listener de erros padrão do ANTLR pelo nosso
            ErroSintatico errorListener = new ErroSintatico();
            lexer.removeErrorListeners();
            lexer.addErrorListener(errorListener);

            // Faz a análise sintática, pega os tokens e constrói a Árvore de Sintaxe Abstrata (AST)
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            PetCareParser parser = new PetCareParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);

            // Inicia o parsing a partir da regra raiz 'programa'
            PetCareParser.ProgramaContext arvore = parser.programa();

            // Interrompe a compilação se houver erro léxico ou sintático
            if (errorListener.temErro()) {
                pw.println(errorListener.getMensagem());
                pw.println("Fim da compilacao");
                return;
            }

            // Faz a análise semântica, percorre a AST validando as regras de negócio do PetCareScript
            Semantico semantico = new Semantico();
            semantico.visitPrograma(arvore);

            // Interrompe a compilação e imprime os erros se a análise semântica falhar
            if (semantico.temErros()) {
                for (String erro : semantico.getErros()) {
                    pw.println(erro);
                }
                pw.println("Fim da compilacao");
                return;
            }

            // Warnings não bloqueiam a compilação: aparecem no terminal e também no HTML gerado.
            if (semantico.temWarnings()) {
                System.out.println("Compilacao concluida com avisos:");
                for (String warning : semantico.getWarnings()) {
                    System.out.println(warning);
                }
            }

            // Se o código for válido, traduz a AST para uma página HTML em formato de dashboard.
            GeradorHTML gerador = new GeradorHTML(semantico.getWarnings());
            String html = gerador.visitPrograma(arvore);

            // Escreve o HTML resultante no arquivo de saída
            pw.println(html);
            System.out.println("Compilacao concluida com sucesso. Arquivo gerado: " + arquivoSaida);

        } catch (IOException e) {
            System.err.println("Erro ao ler/escrever arquivo: " + e.getMessage());
        }
    }
}
