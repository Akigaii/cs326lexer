// Generated from /Users/xmastersteel/IdeaProjects/Lexer/src/Quorum.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuorumParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuorumVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuorumParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(QuorumParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuorumParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(QuorumParser.ProgramContext ctx);
}