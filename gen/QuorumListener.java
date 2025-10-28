// Generated from /Users/xmastersteel/IdeaProjects/Lexer/src/Quorum.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuorumParser}.
 */
public interface QuorumListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuorumParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(QuorumParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(QuorumParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuorumParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(QuorumParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(QuorumParser.ProgramContext ctx);
}