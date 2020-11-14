package tree;

import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

import compiler.CodeBlock;
import compiler.Coordinates;

public class ASTMult implements ASTNode {

    private static final String MULTIPLY_OPERATION_COMPILER = "imul";

    private final ASTNode l, r;

    public ASTMult(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    @Override
    public int eval(Environment<Integer> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        return l.eval(e) * r.eval(e);
    }

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> env) 
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        ASTNode.pushNodes(l, r, cb, MULTIPLY_OPERATION_COMPILER, env);
    }

}
