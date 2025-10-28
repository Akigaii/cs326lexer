// Generated from /Users/xmastersteel/IdeaProjects/Lexer/src/Quorum.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class QuorumParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OUTPUT=1, ON=2, CREATE=3, CONSTANT=4, ELSE_IF=5, ME=6, UNTIL=7, PUBLIC=8, 
		PRIVATE=9, ALERT=10, DETECT=11, ALWAYS=12, CHECK=13, PARENT=14, BLUEPRINT=15, 
		NATIVE=16, INHERITS=17, CAST=18, INPUT=19, SAY=20, NOW=21, WHILE=22, PACKAGE_NAME=23, 
		TIMES=24, REPEAT=25, ELSE=26, RETURNS=27, RETURN=28, AND=29, OR=30, NULL=31, 
		STATIC=32, ACTION=33, COLON=34, INTEGER_KEYWORD=35, NUMBER_KEYWORD=36, 
		TEXT=37, BOOLEAN_KEYWORD=38, USE=39, NOT=40, NOTEQUALS=41, PERIOD=42, 
		COMMA=43, EQUALITY=44, GREATER=45, GREATER_EQUAL=46, LESS=47, LESS_EQUAL=48, 
		PLUS=49, MINUS=50, MULTIPLY=51, DIVIDE=52, MODULO=53, LEFT_SQR_BRACE=54, 
		RIGHT_SQR_BRACE=55, LEFT_PAREN=56, RIGHT_PAREN=57, DOUBLE_QUOTE=58, IF=59, 
		END=60, CLASS=61, BOOLEAN=62, INT=63, DECIMAL=64, ID=65, STRING=66, WS=67, 
		COMMENTS=68;
	public static final int
		RULE_start = 0, RULE_program = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "program"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'output'", "'on'", "'create'", "'constant'", "'elseif'", "'me'", 
			"'until'", "'public'", "'private'", "'alert'", "'detect'", "'always'", 
			"'check'", "'parent'", "'blueprint'", "'system'", "'is'", "'cast'", "'input'", 
			"'say'", "'now'", "'while'", "'package'", "'times'", "'repeat'", "'else'", 
			"'returns'", "'return'", "'and'", "'or'", "'undefined'", "'shared'", 
			"'action'", "':'", "'integer'", "'number'", "'text'", "'boolean'", "'use'", 
			null, null, "'.'", "','", "'='", "'>'", "'>='", "'<'", "'<='", "'+'", 
			"'-'", "'*'", "'/'", "'mod'", "'['", "']'", "'('", "')'", "'\"'", "'if'", 
			"'end'", "'class'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OUTPUT", "ON", "CREATE", "CONSTANT", "ELSE_IF", "ME", "UNTIL", 
			"PUBLIC", "PRIVATE", "ALERT", "DETECT", "ALWAYS", "CHECK", "PARENT", 
			"BLUEPRINT", "NATIVE", "INHERITS", "CAST", "INPUT", "SAY", "NOW", "WHILE", 
			"PACKAGE_NAME", "TIMES", "REPEAT", "ELSE", "RETURNS", "RETURN", "AND", 
			"OR", "NULL", "STATIC", "ACTION", "COLON", "INTEGER_KEYWORD", "NUMBER_KEYWORD", 
			"TEXT", "BOOLEAN_KEYWORD", "USE", "NOT", "NOTEQUALS", "PERIOD", "COMMA", 
			"EQUALITY", "GREATER", "GREATER_EQUAL", "LESS", "LESS_EQUAL", "PLUS", 
			"MINUS", "MULTIPLY", "DIVIDE", "MODULO", "LEFT_SQR_BRACE", "RIGHT_SQR_BRACE", 
			"LEFT_PAREN", "RIGHT_PAREN", "DOUBLE_QUOTE", "IF", "END", "CLASS", "BOOLEAN", 
			"INT", "DECIMAL", "ID", "STRING", "WS", "COMMENTS"
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
	public String getGrammarFileName() { return "Quorum.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QuorumParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuorumListener ) ((QuorumListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuorumListener ) ((QuorumListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuorumVisitor ) return ((QuorumVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			program();
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
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(QuorumParser.EOF, 0); }
		public List<TerminalNode> ID() { return getTokens(QuorumParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QuorumParser.ID, i);
		}
		public List<TerminalNode> INT() { return getTokens(QuorumParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(QuorumParser.INT, i);
		}
		public List<TerminalNode> DECIMAL() { return getTokens(QuorumParser.DECIMAL); }
		public TerminalNode DECIMAL(int i) {
			return getToken(QuorumParser.DECIMAL, i);
		}
		public List<TerminalNode> STRING() { return getTokens(QuorumParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(QuorumParser.STRING, i);
		}
		public List<TerminalNode> BOOLEAN() { return getTokens(QuorumParser.BOOLEAN); }
		public TerminalNode BOOLEAN(int i) {
			return getToken(QuorumParser.BOOLEAN, i);
		}
		public List<TerminalNode> IF() { return getTokens(QuorumParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(QuorumParser.IF, i);
		}
		public List<TerminalNode> ELSE() { return getTokens(QuorumParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(QuorumParser.ELSE, i);
		}
		public List<TerminalNode> CREATE() { return getTokens(QuorumParser.CREATE); }
		public TerminalNode CREATE(int i) {
			return getToken(QuorumParser.CREATE, i);
		}
		public List<TerminalNode> RETURN() { return getTokens(QuorumParser.RETURN); }
		public TerminalNode RETURN(int i) {
			return getToken(QuorumParser.RETURN, i);
		}
		public List<TerminalNode> OUTPUT() { return getTokens(QuorumParser.OUTPUT); }
		public TerminalNode OUTPUT(int i) {
			return getToken(QuorumParser.OUTPUT, i);
		}
		public List<TerminalNode> INPUT() { return getTokens(QuorumParser.INPUT); }
		public TerminalNode INPUT(int i) {
			return getToken(QuorumParser.INPUT, i);
		}
		public List<TerminalNode> ON() { return getTokens(QuorumParser.ON); }
		public TerminalNode ON(int i) {
			return getToken(QuorumParser.ON, i);
		}
		public List<TerminalNode> CLASS() { return getTokens(QuorumParser.CLASS); }
		public TerminalNode CLASS(int i) {
			return getToken(QuorumParser.CLASS, i);
		}
		public List<TerminalNode> ME() { return getTokens(QuorumParser.ME); }
		public TerminalNode ME(int i) {
			return getToken(QuorumParser.ME, i);
		}
		public List<TerminalNode> PUBLIC() { return getTokens(QuorumParser.PUBLIC); }
		public TerminalNode PUBLIC(int i) {
			return getToken(QuorumParser.PUBLIC, i);
		}
		public List<TerminalNode> PRIVATE() { return getTokens(QuorumParser.PRIVATE); }
		public TerminalNode PRIVATE(int i) {
			return getToken(QuorumParser.PRIVATE, i);
		}
		public List<TerminalNode> WHILE() { return getTokens(QuorumParser.WHILE); }
		public TerminalNode WHILE(int i) {
			return getToken(QuorumParser.WHILE, i);
		}
		public List<TerminalNode> END() { return getTokens(QuorumParser.END); }
		public TerminalNode END(int i) {
			return getToken(QuorumParser.END, i);
		}
		public List<TerminalNode> PACKAGE_NAME() { return getTokens(QuorumParser.PACKAGE_NAME); }
		public TerminalNode PACKAGE_NAME(int i) {
			return getToken(QuorumParser.PACKAGE_NAME, i);
		}
		public List<TerminalNode> REPEAT() { return getTokens(QuorumParser.REPEAT); }
		public TerminalNode REPEAT(int i) {
			return getToken(QuorumParser.REPEAT, i);
		}
		public List<TerminalNode> TIMES() { return getTokens(QuorumParser.TIMES); }
		public TerminalNode TIMES(int i) {
			return getToken(QuorumParser.TIMES, i);
		}
		public List<TerminalNode> UNTIL() { return getTokens(QuorumParser.UNTIL); }
		public TerminalNode UNTIL(int i) {
			return getToken(QuorumParser.UNTIL, i);
		}
		public List<TerminalNode> STATIC() { return getTokens(QuorumParser.STATIC); }
		public TerminalNode STATIC(int i) {
			return getToken(QuorumParser.STATIC, i);
		}
		public List<TerminalNode> ACTION() { return getTokens(QuorumParser.ACTION); }
		public TerminalNode ACTION(int i) {
			return getToken(QuorumParser.ACTION, i);
		}
		public List<TerminalNode> COLON() { return getTokens(QuorumParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(QuorumParser.COLON, i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(QuorumParser.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(QuorumParser.PERIOD, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(QuorumParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(QuorumParser.COMMA, i);
		}
		public List<TerminalNode> GREATER() { return getTokens(QuorumParser.GREATER); }
		public TerminalNode GREATER(int i) {
			return getToken(QuorumParser.GREATER, i);
		}
		public List<TerminalNode> LESS() { return getTokens(QuorumParser.LESS); }
		public TerminalNode LESS(int i) {
			return getToken(QuorumParser.LESS, i);
		}
		public List<TerminalNode> GREATER_EQUAL() { return getTokens(QuorumParser.GREATER_EQUAL); }
		public TerminalNode GREATER_EQUAL(int i) {
			return getToken(QuorumParser.GREATER_EQUAL, i);
		}
		public List<TerminalNode> LESS_EQUAL() { return getTokens(QuorumParser.LESS_EQUAL); }
		public TerminalNode LESS_EQUAL(int i) {
			return getToken(QuorumParser.LESS_EQUAL, i);
		}
		public List<TerminalNode> PLUS() { return getTokens(QuorumParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(QuorumParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(QuorumParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(QuorumParser.MINUS, i);
		}
		public List<TerminalNode> MULTIPLY() { return getTokens(QuorumParser.MULTIPLY); }
		public TerminalNode MULTIPLY(int i) {
			return getToken(QuorumParser.MULTIPLY, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(QuorumParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(QuorumParser.DIVIDE, i);
		}
		public List<TerminalNode> MODULO() { return getTokens(QuorumParser.MODULO); }
		public TerminalNode MODULO(int i) {
			return getToken(QuorumParser.MODULO, i);
		}
		public List<TerminalNode> EQUALITY() { return getTokens(QuorumParser.EQUALITY); }
		public TerminalNode EQUALITY(int i) {
			return getToken(QuorumParser.EQUALITY, i);
		}
		public List<TerminalNode> NOTEQUALS() { return getTokens(QuorumParser.NOTEQUALS); }
		public TerminalNode NOTEQUALS(int i) {
			return getToken(QuorumParser.NOTEQUALS, i);
		}
		public List<TerminalNode> AND() { return getTokens(QuorumParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(QuorumParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(QuorumParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(QuorumParser.OR, i);
		}
		public List<TerminalNode> NOT() { return getTokens(QuorumParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(QuorumParser.NOT, i);
		}
		public List<TerminalNode> NULL() { return getTokens(QuorumParser.NULL); }
		public TerminalNode NULL(int i) {
			return getToken(QuorumParser.NULL, i);
		}
		public List<TerminalNode> USE() { return getTokens(QuorumParser.USE); }
		public TerminalNode USE(int i) {
			return getToken(QuorumParser.USE, i);
		}
		public List<TerminalNode> CONSTANT() { return getTokens(QuorumParser.CONSTANT); }
		public TerminalNode CONSTANT(int i) {
			return getToken(QuorumParser.CONSTANT, i);
		}
		public List<TerminalNode> ALERT() { return getTokens(QuorumParser.ALERT); }
		public TerminalNode ALERT(int i) {
			return getToken(QuorumParser.ALERT, i);
		}
		public List<TerminalNode> DETECT() { return getTokens(QuorumParser.DETECT); }
		public TerminalNode DETECT(int i) {
			return getToken(QuorumParser.DETECT, i);
		}
		public List<TerminalNode> ALWAYS() { return getTokens(QuorumParser.ALWAYS); }
		public TerminalNode ALWAYS(int i) {
			return getToken(QuorumParser.ALWAYS, i);
		}
		public List<TerminalNode> CHECK() { return getTokens(QuorumParser.CHECK); }
		public TerminalNode CHECK(int i) {
			return getToken(QuorumParser.CHECK, i);
		}
		public List<TerminalNode> PARENT() { return getTokens(QuorumParser.PARENT); }
		public TerminalNode PARENT(int i) {
			return getToken(QuorumParser.PARENT, i);
		}
		public List<TerminalNode> BLUEPRINT() { return getTokens(QuorumParser.BLUEPRINT); }
		public TerminalNode BLUEPRINT(int i) {
			return getToken(QuorumParser.BLUEPRINT, i);
		}
		public List<TerminalNode> NATIVE() { return getTokens(QuorumParser.NATIVE); }
		public TerminalNode NATIVE(int i) {
			return getToken(QuorumParser.NATIVE, i);
		}
		public List<TerminalNode> INHERITS() { return getTokens(QuorumParser.INHERITS); }
		public TerminalNode INHERITS(int i) {
			return getToken(QuorumParser.INHERITS, i);
		}
		public List<TerminalNode> CAST() { return getTokens(QuorumParser.CAST); }
		public TerminalNode CAST(int i) {
			return getToken(QuorumParser.CAST, i);
		}
		public List<TerminalNode> NOW() { return getTokens(QuorumParser.NOW); }
		public TerminalNode NOW(int i) {
			return getToken(QuorumParser.NOW, i);
		}
		public List<TerminalNode> SAY() { return getTokens(QuorumParser.SAY); }
		public TerminalNode SAY(int i) {
			return getToken(QuorumParser.SAY, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuorumListener ) ((QuorumListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuorumListener ) ((QuorumListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuorumVisitor ) return ((QuorumVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -558446869324234786L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 7L) != 0)) {
				{
				{
				setState(6);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -558446869324234786L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 7L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(11);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(12);
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

	public static final String _serializedATN =
		"\u0004\u0001D\u000f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0005\u0001\b\b\u0001\n\u0001\f\u0001\u000b"+
		"\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0002\u0000\u0002"+
		"\u0000\u0001\u0005\u0000\u0001\u0004\u0006\u001a\u001c\"\'5;B\r\u0000"+
		"\u0004\u0001\u0000\u0000\u0000\u0002\t\u0001\u0000\u0000\u0000\u0004\u0005"+
		"\u0003\u0002\u0001\u0000\u0005\u0001\u0001\u0000\u0000\u0000\u0006\b\u0007"+
		"\u0000\u0000\u0000\u0007\u0006\u0001\u0000\u0000\u0000\b\u000b\u0001\u0000"+
		"\u0000\u0000\t\u0007\u0001\u0000\u0000\u0000\t\n\u0001\u0000\u0000\u0000"+
		"\n\f\u0001\u0000\u0000\u0000\u000b\t\u0001\u0000\u0000\u0000\f\r\u0005"+
		"\u0000\u0000\u0001\r\u0003\u0001\u0000\u0000\u0000\u0001\t";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}