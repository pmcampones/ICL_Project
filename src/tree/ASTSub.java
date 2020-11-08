package tree;

import compiler.CodeBlock;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTSub implements ASTNode {

    private static final String SUBTRACTION_OPERATION_COMPILER = "isub\n";

    private final ASTNode l, r;

    public ASTSub(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    public int eval(Environment e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        return l.eval(e) - r.eval(e);
    }

    @Override
    public void compile(CodeBlock cb, Environment env) {
        ASTNode.pushNodes(l, r, cb, SUBTRACTION_OPERATION_COMPILER, env);
    }

}
