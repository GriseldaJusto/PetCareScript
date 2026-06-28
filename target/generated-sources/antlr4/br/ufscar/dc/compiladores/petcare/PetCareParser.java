// Generated from br/ufscar/dc/compiladores/petcare/PetCare.g4 by ANTLR 4.13.1
package br.ufscar.dc.compiladores.petcare;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PetCareParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, ESPECIE=17, 
		TEMPO=18, DATA=19, HORA=20, NUM=21, STRING=22, COMENTARIO=23, WS=24, ERRO=25;
	public static final int
		RULE_programa = 0, RULE_declVacina = 1, RULE_campoDeclVacina = 2, RULE_declIdade = 3, 
		RULE_declValidade = 4, RULE_pet = 5, RULE_campoPet = 6, RULE_especie = 7, 
		RULE_idade = 8, RULE_tutor = 9, RULE_vacina = 10, RULE_remedio = 11, RULE_rotina = 12, 
		RULE_itemRotina = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declVacina", "campoDeclVacina", "declIdade", "declValidade", 
			"pet", "campoPet", "especie", "idade", "tutor", "vacina", "remedio", 
			"rotina", "itemRotina"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'vacina'", "'{'", "'}'", "'idade'", "':'", "'validade'", "'pet'", 
			"'especie'", "'tutor'", "'em'", "'remedio'", "'dose'", "'por'", "'dias'", 
			"'rotina'", "'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "ESPECIE", "TEMPO", "DATA", "HORA", "NUM", 
			"STRING", "COMENTARIO", "WS", "ERRO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PetCare.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PetCareParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PetCareParser.EOF, 0); }
		public List<DeclVacinaContext> declVacina() {
			return getRuleContexts(DeclVacinaContext.class);
		}
		public DeclVacinaContext declVacina(int i) {
			return getRuleContext(DeclVacinaContext.class,i);
		}
		public List<PetContext> pet() {
			return getRuleContexts(PetContext.class);
		}
		public PetContext pet(int i) {
			return getRuleContext(PetContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PetCareVisitor ) return ((PetCareVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(28);
				declVacina();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				pet();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 );
			setState(39);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclVacinaContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PetCareParser.STRING, 0); }
		public List<CampoDeclVacinaContext> campoDeclVacina() {
			return getRuleContexts(CampoDeclVacinaContext.class);
		}
		public CampoDeclVacinaContext campoDeclVacina(int i) {
			return getRuleContext(CampoDeclVacinaContext.class,i);
		}
		public DeclVacinaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declVacina; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).enterDeclVacina(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).exitDeclVacina(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PetCareVisitor ) return ((PetCareVisitor<? extends T>)visitor).visitDeclVacina(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclVacinaContext declVacina() throws RecognitionException {
		DeclVacinaContext _localctx = new DeclVacinaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declVacina);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__0);
			setState(42);
			match(STRING);
			setState(43);
			match(T__1);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 336L) != 0)) {
				{
				{
				setState(44);
				campoDeclVacina();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CampoDeclVacinaContext extends ParserRuleContext {
		public EspecieContext especie() {
			return getRuleContext(EspecieContext.class,0);
		}
		public DeclIdadeContext declIdade() {
			return getRuleContext(DeclIdadeContext.class,0);
		}
		public DeclValidadeContext declValidade() {
			return getRuleContext(DeclValidadeContext.class,0);
		}
		public CampoDeclVacinaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_campoDeclVacina; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).enterCampoDeclVacina(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).exitCampoDeclVacina(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PetCareVisitor ) return ((PetCareVisitor<? extends T>)visitor).visitCampoDeclVacina(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CampoDeclVacinaContext campoDeclVacina() throws RecognitionException {
		CampoDeclVacinaContext _localctx = new CampoDeclVacinaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_campoDeclVacina);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				especie();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				declIdade();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				declValidade();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclIdadeContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(PetCareParser.NUM, 0); }
		public TerminalNode TEMPO() { return getToken(PetCareParser.TEMPO, 0); }
		public DeclIdadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declIdade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).enterDeclIdade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).exitDeclIdade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PetCareVisitor ) return ((PetCareVisitor<? extends T>)visitor).visitDeclIdade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclIdadeContext declIdade() throws RecognitionException {
		DeclIdadeContext _localctx = new DeclIdadeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declIdade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(T__3);
			setState(58);
			match(T__4);
			setState(59);
			match(NUM);
			setState(60);
			match(TEMPO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclValidadeContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(PetCareParser.NUM, 0); }
		public TerminalNode TEMPO() { return getToken(PetCareParser.TEMPO, 0); }
		public DeclValidadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declValidade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).enterDeclValidade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).exitDeclValidade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PetCareVisitor ) return ((PetCareVisitor<? extends T>)visitor).visitDeclValidade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclValidadeContext declValidade() throws RecognitionException {
		DeclValidadeContext _localctx = new DeclValidadeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declValidade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__5);
			setState(63);
			match(T__4);
			setState(64);
			match(NUM);
			setState(65);
			match(TEMPO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PetContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PetCareParser.STRING, 0); }
		public List<CampoPetContext> campoPet() {
			return getRuleContexts(CampoPetContext.class);
		}
		public CampoPetContext campoPet(int i) {
			return getRuleContext(CampoPetContext.class,i);
		}
		public PetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).enterPet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).exitPet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PetCareVisitor ) return ((PetCareVisitor<? extends T>)visitor).visitPet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PetContext pet() throws RecognitionException {
		PetContext _localctx = new PetContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_pet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__6);
			setState(68);
			match(STRING);
			setState(69);
			match(T__1);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35602L) != 0)) {
				{
				{
				setState(70);
				campoPet();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CampoPetContext extends ParserRuleContext {
		public EspecieContext especie() {
			return getRuleContext(EspecieContext.class,0);
		}
		public IdadeContext idade() {
			return getRuleContext(IdadeContext.class,0);
		}
		public TutorContext tutor() {
			return getRuleContext(TutorContext.class,0);
		}
		public VacinaContext vacina() {
			return getRuleContext(VacinaContext.class,0);
		}
		public RemedioContext remedio() {
			return getRuleContext(RemedioContext.class,0);
		}
		public RotinaContext rotina() {
			return getRuleContext(RotinaContext.class,0);
		}
		public CampoPetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_campoPet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).enterCampoPet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).exitCampoPet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PetCareVisitor ) return ((PetCareVisitor<? extends T>)visitor).visitCampoPet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CampoPetContext campoPet() throws RecognitionException {
		CampoPetContext _localctx = new CampoPetContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_campoPet);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				especie();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				idade();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				tutor();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				vacina();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				remedio();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				rotina();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EspecieContext extends ParserRuleContext {
		public TerminalNode ESPECIE() { return getToken(PetCareParser.ESPECIE, 0); }
		public EspecieContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_especie; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).enterEspecie(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).exitEspecie(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PetCareVisitor ) return ((PetCareVisitor<? extends T>)visitor).visitEspecie(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EspecieContext especie() throws RecognitionException {
		EspecieContext _localctx = new EspecieContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_especie);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__7);
			setState(87);
			match(T__4);
			setState(88);
			match(ESPECIE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdadeContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(PetCareParser.NUM, 0); }
		public IdadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).enterIdade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).exitIdade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PetCareVisitor ) return ((PetCareVisitor<? extends T>)visitor).visitIdade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdadeContext idade() throws RecognitionException {
		IdadeContext _localctx = new IdadeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_idade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__3);
			setState(91);
			match(T__4);
			setState(92);
			match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TutorContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PetCareParser.STRING, 0); }
		public TutorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tutor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).enterTutor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).exitTutor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PetCareVisitor ) return ((PetCareVisitor<? extends T>)visitor).visitTutor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TutorContext tutor() throws RecognitionException {
		TutorContext _localctx = new TutorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tutor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__8);
			setState(95);
			match(T__4);
			setState(96);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VacinaContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PetCareParser.STRING, 0); }
		public TerminalNode DATA() { return getToken(PetCareParser.DATA, 0); }
		public VacinaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vacina; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).enterVacina(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).exitVacina(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PetCareVisitor ) return ((PetCareVisitor<? extends T>)visitor).visitVacina(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VacinaContext vacina() throws RecognitionException {
		VacinaContext _localctx = new VacinaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_vacina);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__0);
			setState(99);
			match(STRING);
			setState(100);
			match(T__9);
			setState(101);
			match(DATA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RemedioContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(PetCareParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(PetCareParser.STRING, i);
		}
		public TerminalNode NUM() { return getToken(PetCareParser.NUM, 0); }
		public RemedioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_remedio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).enterRemedio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).exitRemedio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PetCareVisitor ) return ((PetCareVisitor<? extends T>)visitor).visitRemedio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RemedioContext remedio() throws RecognitionException {
		RemedioContext _localctx = new RemedioContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_remedio);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__10);
			setState(104);
			match(STRING);
			setState(105);
			match(T__11);
			setState(106);
			match(STRING);
			setState(107);
			match(T__12);
			setState(108);
			match(NUM);
			setState(109);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RotinaContext extends ParserRuleContext {
		public List<ItemRotinaContext> itemRotina() {
			return getRuleContexts(ItemRotinaContext.class);
		}
		public ItemRotinaContext itemRotina(int i) {
			return getRuleContext(ItemRotinaContext.class,i);
		}
		public RotinaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotina; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).enterRotina(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).exitRotina(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PetCareVisitor ) return ((PetCareVisitor<? extends T>)visitor).visitRotina(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RotinaContext rotina() throws RecognitionException {
		RotinaContext _localctx = new RotinaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rotina);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__14);
			setState(112);
			match(T__1);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HORA) {
				{
				{
				setState(113);
				itemRotina();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ItemRotinaContext extends ParserRuleContext {
		public TerminalNode HORA() { return getToken(PetCareParser.HORA, 0); }
		public TerminalNode STRING() { return getToken(PetCareParser.STRING, 0); }
		public ItemRotinaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemRotina; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).enterItemRotina(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PetCareListener ) ((PetCareListener)listener).exitItemRotina(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PetCareVisitor ) return ((PetCareVisitor<? extends T>)visitor).visitItemRotina(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemRotinaContext itemRotina() throws RecognitionException {
		ItemRotinaContext _localctx = new ItemRotinaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_itemRotina);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(HORA);
			setState(122);
			match(T__15);
			setState(123);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0019~\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0005\u0000\u001e\b\u0000\n\u0000"+
		"\f\u0000!\t\u0000\u0001\u0000\u0004\u0000$\b\u0000\u000b\u0000\f\u0000"+
		"%\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001.\b\u0001\n\u0001\f\u00011\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00028\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005H\b\u0005\n\u0005\f\u0005K\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006U\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0005\fs\b\f\n\f\f\fv\t\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0000\u0000\u000e\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0000{\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0002)\u0001\u0000\u0000\u0000\u00047\u0001\u0000"+
		"\u0000\u0000\u00069\u0001\u0000\u0000\u0000\b>\u0001\u0000\u0000\u0000"+
		"\nC\u0001\u0000\u0000\u0000\fT\u0001\u0000\u0000\u0000\u000eV\u0001\u0000"+
		"\u0000\u0000\u0010Z\u0001\u0000\u0000\u0000\u0012^\u0001\u0000\u0000\u0000"+
		"\u0014b\u0001\u0000\u0000\u0000\u0016g\u0001\u0000\u0000\u0000\u0018o"+
		"\u0001\u0000\u0000\u0000\u001ay\u0001\u0000\u0000\u0000\u001c\u001e\u0003"+
		"\u0002\u0001\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001e!\u0001\u0000"+
		"\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000"+
		"\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000\"$\u0003"+
		"\n\u0005\u0000#\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%#"+
		"\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000"+
		"\u0000\'(\u0005\u0000\u0000\u0001(\u0001\u0001\u0000\u0000\u0000)*\u0005"+
		"\u0001\u0000\u0000*+\u0005\u0016\u0000\u0000+/\u0005\u0002\u0000\u0000"+
		",.\u0003\u0004\u0002\u0000-,\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000"+
		"\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000002\u0001\u0000"+
		"\u0000\u00001/\u0001\u0000\u0000\u000023\u0005\u0003\u0000\u00003\u0003"+
		"\u0001\u0000\u0000\u000048\u0003\u000e\u0007\u000058\u0003\u0006\u0003"+
		"\u000068\u0003\b\u0004\u000074\u0001\u0000\u0000\u000075\u0001\u0000\u0000"+
		"\u000076\u0001\u0000\u0000\u00008\u0005\u0001\u0000\u0000\u00009:\u0005"+
		"\u0004\u0000\u0000:;\u0005\u0005\u0000\u0000;<\u0005\u0015\u0000\u0000"+
		"<=\u0005\u0012\u0000\u0000=\u0007\u0001\u0000\u0000\u0000>?\u0005\u0006"+
		"\u0000\u0000?@\u0005\u0005\u0000\u0000@A\u0005\u0015\u0000\u0000AB\u0005"+
		"\u0012\u0000\u0000B\t\u0001\u0000\u0000\u0000CD\u0005\u0007\u0000\u0000"+
		"DE\u0005\u0016\u0000\u0000EI\u0005\u0002\u0000\u0000FH\u0003\f\u0006\u0000"+
		"GF\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000"+
		"\u0000IJ\u0001\u0000\u0000\u0000JL\u0001\u0000\u0000\u0000KI\u0001\u0000"+
		"\u0000\u0000LM\u0005\u0003\u0000\u0000M\u000b\u0001\u0000\u0000\u0000"+
		"NU\u0003\u000e\u0007\u0000OU\u0003\u0010\b\u0000PU\u0003\u0012\t\u0000"+
		"QU\u0003\u0014\n\u0000RU\u0003\u0016\u000b\u0000SU\u0003\u0018\f\u0000"+
		"TN\u0001\u0000\u0000\u0000TO\u0001\u0000\u0000\u0000TP\u0001\u0000\u0000"+
		"\u0000TQ\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TS\u0001\u0000"+
		"\u0000\u0000U\r\u0001\u0000\u0000\u0000VW\u0005\b\u0000\u0000WX\u0005"+
		"\u0005\u0000\u0000XY\u0005\u0011\u0000\u0000Y\u000f\u0001\u0000\u0000"+
		"\u0000Z[\u0005\u0004\u0000\u0000[\\\u0005\u0005\u0000\u0000\\]\u0005\u0015"+
		"\u0000\u0000]\u0011\u0001\u0000\u0000\u0000^_\u0005\t\u0000\u0000_`\u0005"+
		"\u0005\u0000\u0000`a\u0005\u0016\u0000\u0000a\u0013\u0001\u0000\u0000"+
		"\u0000bc\u0005\u0001\u0000\u0000cd\u0005\u0016\u0000\u0000de\u0005\n\u0000"+
		"\u0000ef\u0005\u0013\u0000\u0000f\u0015\u0001\u0000\u0000\u0000gh\u0005"+
		"\u000b\u0000\u0000hi\u0005\u0016\u0000\u0000ij\u0005\f\u0000\u0000jk\u0005"+
		"\u0016\u0000\u0000kl\u0005\r\u0000\u0000lm\u0005\u0015\u0000\u0000mn\u0005"+
		"\u000e\u0000\u0000n\u0017\u0001\u0000\u0000\u0000op\u0005\u000f\u0000"+
		"\u0000pt\u0005\u0002\u0000\u0000qs\u0003\u001a\r\u0000rq\u0001\u0000\u0000"+
		"\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000"+
		"\u0000\u0000uw\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000wx\u0005"+
		"\u0003\u0000\u0000x\u0019\u0001\u0000\u0000\u0000yz\u0005\u0014\u0000"+
		"\u0000z{\u0005\u0010\u0000\u0000{|\u0005\u0016\u0000\u0000|\u001b\u0001"+
		"\u0000\u0000\u0000\u0007\u001f%/7ITt";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}