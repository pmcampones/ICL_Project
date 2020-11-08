package tree;

import compiler.CodeBlock;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTNeg implements ASTNode {

    private final ASTNode node;

    public ASTNeg(ASTNode node) {this.node = node;}

    @Override
    public int eval(Environment e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        return -node.eval(e);
    }

    @Override
    public void compile(CodeBlock cb, Environment env) {
        new ASTMult(node, new ASTNum(-1)).compile(cb, env);
    }

}
