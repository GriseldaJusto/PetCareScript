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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, ESPECIE=16, 
		DATA=17, HORA=18, NUM=19, STRING=20, COMENTARIO=21, WS=22, ERRO=23;
	public static final int
		RULE_programa = 0, RULE_pet = 1, RULE_campoPet = 2, RULE_especie = 3, 
		RULE_idade = 4, RULE_tutor = 5, RULE_vacina = 6, RULE_remedio = 7, RULE_rotina = 8, 
		RULE_itemRotina = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "pet", "campoPet", "especie", "idade", "tutor", "vacina", 
			"remedio", "rotina", "itemRotina"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'pet'", "'{'", "'}'", "'especie'", "':'", "'idade'", "'tutor'", 
			"'vacina'", "'em'", "'remedio'", "'dose'", "'por'", "'dias'", "'rotina'", 
			"'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "ESPECIE", "DATA", "HORA", "NUM", "STRING", "COMENTARIO", 
			"WS", "ERRO"
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
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				pet();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(25);
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
		enterRule(_localctx, 2, RULE_pet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(T__0);
			setState(28);
			match(STRING);
			setState(29);
			match(T__1);
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17872L) != 0)) {
				{
				{
				setState(30);
				campoPet();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
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
		enterRule(_localctx, 4, RULE_campoPet);
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				especie();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				idade();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				tutor();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				vacina();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(42);
				remedio();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 6);
				{
				setState(43);
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
		enterRule(_localctx, 6, RULE_especie);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__3);
			setState(47);
			match(T__4);
			setState(48);
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
		enterRule(_localctx, 8, RULE_idade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__5);
			setState(51);
			match(T__4);
			setState(52);
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
		enterRule(_localctx, 10, RULE_tutor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__6);
			setState(55);
			match(T__4);
			setState(56);
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
		enterRule(_localctx, 12, RULE_vacina);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(T__7);
			setState(59);
			match(STRING);
			setState(60);
			match(T__8);
			setState(61);
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
		enterRule(_localctx, 14, RULE_remedio);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__9);
			setState(64);
			match(STRING);
			setState(65);
			match(T__10);
			setState(66);
			match(STRING);
			setState(67);
			match(T__11);
			setState(68);
			match(NUM);
			setState(69);
			match(T__12);
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
		enterRule(_localctx, 16, RULE_rotina);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__13);
			setState(72);
			match(T__1);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HORA) {
				{
				{
				setState(73);
				itemRotina();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79);
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
		enterRule(_localctx, 18, RULE_itemRotina);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(HORA);
			setState(82);
			match(T__14);
			setState(83);
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
		"\u0004\u0001\u0017V\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0004\u0000\u0016\b\u0000\u000b"+
		"\u0000\f\u0000\u0017\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001 \b\u0001\n\u0001\f\u0001#\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002-\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0005\bK\b\b\n\b\f\bN\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0000\u0000\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0000\u0000S\u0000\u0015\u0001\u0000\u0000\u0000\u0002\u001b\u0001"+
		"\u0000\u0000\u0000\u0004,\u0001\u0000\u0000\u0000\u0006.\u0001\u0000\u0000"+
		"\u0000\b2\u0001\u0000\u0000\u0000\n6\u0001\u0000\u0000\u0000\f:\u0001"+
		"\u0000\u0000\u0000\u000e?\u0001\u0000\u0000\u0000\u0010G\u0001\u0000\u0000"+
		"\u0000\u0012Q\u0001\u0000\u0000\u0000\u0014\u0016\u0003\u0002\u0001\u0000"+
		"\u0015\u0014\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000"+
		"\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000"+
		"\u0018\u0019\u0001\u0000\u0000\u0000\u0019\u001a\u0005\u0000\u0000\u0001"+
		"\u001a\u0001\u0001\u0000\u0000\u0000\u001b\u001c\u0005\u0001\u0000\u0000"+
		"\u001c\u001d\u0005\u0014\u0000\u0000\u001d!\u0005\u0002\u0000\u0000\u001e"+
		" \u0003\u0004\u0002\u0000\u001f\u001e\u0001\u0000\u0000\u0000 #\u0001"+
		"\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000"+
		"\u0000\"$\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000$%\u0005\u0003"+
		"\u0000\u0000%\u0003\u0001\u0000\u0000\u0000&-\u0003\u0006\u0003\u0000"+
		"\'-\u0003\b\u0004\u0000(-\u0003\n\u0005\u0000)-\u0003\f\u0006\u0000*-"+
		"\u0003\u000e\u0007\u0000+-\u0003\u0010\b\u0000,&\u0001\u0000\u0000\u0000"+
		",\'\u0001\u0000\u0000\u0000,(\u0001\u0000\u0000\u0000,)\u0001\u0000\u0000"+
		"\u0000,*\u0001\u0000\u0000\u0000,+\u0001\u0000\u0000\u0000-\u0005\u0001"+
		"\u0000\u0000\u0000./\u0005\u0004\u0000\u0000/0\u0005\u0005\u0000\u0000"+
		"01\u0005\u0010\u0000\u00001\u0007\u0001\u0000\u0000\u000023\u0005\u0006"+
		"\u0000\u000034\u0005\u0005\u0000\u000045\u0005\u0013\u0000\u00005\t\u0001"+
		"\u0000\u0000\u000067\u0005\u0007\u0000\u000078\u0005\u0005\u0000\u0000"+
		"89\u0005\u0014\u0000\u00009\u000b\u0001\u0000\u0000\u0000:;\u0005\b\u0000"+
		"\u0000;<\u0005\u0014\u0000\u0000<=\u0005\t\u0000\u0000=>\u0005\u0011\u0000"+
		"\u0000>\r\u0001\u0000\u0000\u0000?@\u0005\n\u0000\u0000@A\u0005\u0014"+
		"\u0000\u0000AB\u0005\u000b\u0000\u0000BC\u0005\u0014\u0000\u0000CD\u0005"+
		"\f\u0000\u0000DE\u0005\u0013\u0000\u0000EF\u0005\r\u0000\u0000F\u000f"+
		"\u0001\u0000\u0000\u0000GH\u0005\u000e\u0000\u0000HL\u0005\u0002\u0000"+
		"\u0000IK\u0003\u0012\t\u0000JI\u0001\u0000\u0000\u0000KN\u0001\u0000\u0000"+
		"\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MO\u0001\u0000"+
		"\u0000\u0000NL\u0001\u0000\u0000\u0000OP\u0005\u0003\u0000\u0000P\u0011"+
		"\u0001\u0000\u0000\u0000QR\u0005\u0012\u0000\u0000RS\u0005\u000f\u0000"+
		"\u0000ST\u0005\u0014\u0000\u0000T\u0013\u0001\u0000\u0000\u0000\u0004"+
		"\u0017!,L";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}