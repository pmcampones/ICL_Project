package tree;

import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

import java.util.Queue;

public class ASTNeg implements ASTNode {

    private final ASTNode node;

    public ASTNeg(ASTNode node) {this.node = node;}

    @Override
    public int eval(Environment e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        return -node.eval(e);
    }

    @Override
    public void compile(Queue<String> codeBlock) {
        new ASTMult(node, new ASTNum(-1)).compile(codeBlock);
    }

}
