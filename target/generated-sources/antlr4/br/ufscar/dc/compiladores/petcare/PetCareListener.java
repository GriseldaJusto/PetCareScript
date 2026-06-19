// Generated from br/ufscar/dc/compiladores/petcare/PetCare.g4 by ANTLR 4.13.1
package br.ufscar.dc.compiladores.petcare;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PetCareParser}.
 */
public interface PetCareListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PetCareParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(PetCareParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PetCareParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(PetCareParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PetCareParser#pet}.
	 * @param ctx the parse tree
	 */
	void enterPet(PetCareParser.PetContext ctx);
	/**
	 * Exit a parse tree produced by {@link PetCareParser#pet}.
	 * @param ctx the parse tree
	 */
	void exitPet(PetCareParser.PetContext ctx);
	/**
	 * Enter a parse tree produced by {@link PetCareParser#campoPet}.
	 * @param ctx the parse tree
	 */
	void enterCampoPet(PetCareParser.CampoPetContext ctx);
	/**
	 * Exit a parse tree produced by {@link PetCareParser#campoPet}.
	 * @param ctx the parse tree
	 */
	void exitCampoPet(PetCareParser.CampoPetContext ctx);
	/**
	 * Enter a parse tree produced by {@link PetCareParser#especie}.
	 * @param ctx the parse tree
	 */
	void enterEspecie(PetCareParser.EspecieContext ctx);
	/**
	 * Exit a parse tree produced by {@link PetCareParser#especie}.
	 * @param ctx the parse tree
	 */
	void exitEspecie(PetCareParser.EspecieContext ctx);
	/**
	 * Enter a parse tree produced by {@link PetCareParser#idade}.
	 * @param ctx the parse tree
	 */
	void enterIdade(PetCareParser.IdadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PetCareParser#idade}.
	 * @param ctx the parse tree
	 */
	void exitIdade(PetCareParser.IdadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PetCareParser#tutor}.
	 * @param ctx the parse tree
	 */
	void enterTutor(PetCareParser.TutorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PetCareParser#tutor}.
	 * @param ctx the parse tree
	 */
	void exitTutor(PetCareParser.TutorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PetCareParser#vacina}.
	 * @param ctx the parse tree
	 */
	void enterVacina(PetCareParser.VacinaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PetCareParser#vacina}.
	 * @param ctx the parse tree
	 */
	void exitVacina(PetCareParser.VacinaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PetCareParser#remedio}.
	 * @param ctx the parse tree
	 */
	void enterRemedio(PetCareParser.RemedioContext ctx);
	/**
	 * Exit a parse tree produced by {@link PetCareParser#remedio}.
	 * @param ctx the parse tree
	 */
	void exitRemedio(PetCareParser.RemedioContext ctx);
	/**
	 * Enter a parse tree produced by {@link PetCareParser#rotina}.
	 * @param ctx the parse tree
	 */
	void enterRotina(PetCareParser.RotinaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PetCareParser#rotina}.
	 * @param ctx the parse tree
	 */
	void exitRotina(PetCareParser.RotinaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PetCareParser#itemRotina}.
	 * @param ctx the parse tree
	 */
	void enterItemRotina(PetCareParser.ItemRotinaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PetCareParser#itemRotina}.
	 * @param ctx the parse tree
	 */
	void exitItemRotina(PetCareParser.ItemRotinaContext ctx);
}