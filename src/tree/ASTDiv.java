package tree;

import compiler.CodeBlock;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTDiv implements ASTNode {

    private static final String DIVISION_OPERATION_COMPILER = "idiv\n";

    private final ASTNode l, r;

    public ASTDiv(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    @Override
    public int eval(Environment e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        return l.eval(e) / r.eval(e);
    }

    @Override
    public void compile(CodeBlock cb, Environment env) {
        ASTNode.pushNodes(l, r, cb, DIVISION_OPERATION_COMPILER, env);
    }


}
