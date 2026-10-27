package zip.jespersen.mathfx.parser;

import java.util.List;
import java.util.Stack;
import zip.jespersen.mathfx.nodes.INode;
import zip.jespersen.mathfx.nodes.NumberNode;
import zip.jespersen.mathfx.nodes.OperationNode;
import zip.jespersen.mathfx.tokens.BracketToken;
import zip.jespersen.mathfx.tokens.MathToken;
import zip.jespersen.mathfx.tokens.NumberToken;
import zip.jespersen.mathfx.tokens.OperationToken;
import zip.jespersen.mathfx.types.Operator;
import zip.jespersen.mathfx.utils.MathUtil;

/**
 * Parses a list of {@link MathToken}s into a tree of {@link INode}s
 * using a recursive descent parser.
 */
public final class NodeParser {

    private final List<MathToken> tokens;

    /**
     * Creates a new node parser for the given tokens.
     *
     * @param tokens the tokens in infix order to parse
     */
    public NodeParser(List<MathToken> tokens) {
        this.tokens = tokens;
    }

    /**
     * Parses the tokens into a node tree, respecting operator precedence
     * and brackets.
     *
     * @return the root node of the resulting tree
     * @throws Exception if the tokens do not form a valid expression,
     *                   e.g. because of a missing closing bracket
     */
    public INode computeNodeRecursive() throws Exception {
        RecursiveDescent recursiveDescent = new RecursiveDescent();
        return recursiveDescent.produceNode(tokens);
    }

    static class RecursiveDescent {

        private int i = 0;

        public RecursiveDescent() {
            i = 0;
        }

        public INode produceNode(List<MathToken> tokens) throws Exception {
            return buildAdditionAndSubtractNode(tokens);
        }

        private INode buildAdditionAndSubtractNode(List<MathToken> tokens) throws Exception {
            INode x = buildMultiplyAndDivideNode(tokens);
            MathToken token = tokens.get(i);

            while (token instanceof OperationToken operationToken && (operationToken.getOperator() == Operator.MINUS
                    || operationToken.getOperator() == Operator.PLUS)) {
                if (i < tokens.size() - 1)
                    i++;
                INode y = buildMultiplyAndDivideNode(tokens);
                INode node = new OperationNode(
                        operationToken.getOperator())
                        .setLeftNode(x)
                        .setRightNode(y);
                x = node;
                token = tokens.get(i);
            }
            return x;
        }

        private INode buildMultiplyAndDivideNode(
                List<MathToken> tokens) throws Exception {

            INode x = buildPowerOperationNode(tokens);
            MathToken token = tokens.get(i);

            while (token instanceof OperationToken operationToken && (operationToken.getOperator() == Operator.DIVIDE
                    || operationToken.getOperator() == Operator.MULTI)) {
                if (i < tokens.size() - 1)
                    i++;
                INode y = buildPowerOperationNode(tokens);
                INode node = new OperationNode(
                        operationToken.getOperator())
                        .setLeftNode(x)
                        .setRightNode(y);
                x = (node);
                token = tokens.get(i);
            }
            return x;
        }

        private INode buildPowerOperationNode(
                List<MathToken> tokens) throws Exception {
            // TODO: Add ^ to Token Parser
            return buildNumberAndProduceBracketNode(tokens);
        }

        private INode buildNumberAndProduceBracketNode(
                List<MathToken> tokens) throws Exception {
            MathToken token = tokens.get(i);
            if (token instanceof NumberToken numberToken) {
                if (i < tokens.size() - 1)
                    i++;
                return new NumberNode(numberToken.getNumber());
            } else if (token instanceof BracketToken bracketToken && bracketToken.isOpen()) {
                if (i < tokens.size() - 1)
                    i++;
                INode x = buildAdditionAndSubtractNode(tokens);
                boolean isBracket = (tokens.get(i) instanceof BracketToken);
                boolean isBracketClosed = (tokens.get(i) instanceof BracketToken bt && !bt.isOpen());
                if (!isBracket || !isBracketClosed) {
                    throw new Exception("Not expected!");
                }
                if (i < tokens.size() - 1)
                    i++;
                return x;
            } else {
                throw new Exception();
            }
        }
    }

}
