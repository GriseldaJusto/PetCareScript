// Generated from br/ufscar/dc/compiladores/petcare/PetCare.g4 by ANTLR 4.13.1
package br.ufscar.dc.compiladores.petcare;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PetCareParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PetCareVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PetCareParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(PetCareParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PetCareParser#declVacina}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclVacina(PetCareParser.DeclVacinaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PetCareParser#campoDeclVacina}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCampoDeclVacina(PetCareParser.CampoDeclVacinaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PetCareParser#declIdade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclIdade(PetCareParser.DeclIdadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PetCareParser#declValidade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclValidade(PetCareParser.DeclValidadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PetCareParser#pet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPet(PetCareParser.PetContext ctx);
	/**
	 * Visit a parse tree produced by {@link PetCareParser#campoPet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCampoPet(PetCareParser.CampoPetContext ctx);
	/**
	 * Visit a parse tree produced by {@link PetCareParser#especie}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEspecie(PetCareParser.EspecieContext ctx);
	/**
	 * Visit a parse tree produced by {@link PetCareParser#idade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdade(PetCareParser.IdadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PetCareParser#tutor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTutor(PetCareParser.TutorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PetCareParser#vacina}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVacina(PetCareParser.VacinaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PetCareParser#remedio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemedio(PetCareParser.RemedioContext ctx);
	/**
	 * Visit a parse tree produced by {@link PetCareParser#rotina}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRotina(PetCareParser.RotinaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PetCareParser#itemRotina}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemRotina(PetCareParser.ItemRotinaContext ctx);
}