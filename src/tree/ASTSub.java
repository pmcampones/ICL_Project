package tree;

import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

import java.util.Queue;

public class ASTSub implements ASTNode {

    private static final String SUBTRACTION_OPERATION_COMPILER = "isub\n";

    private final ASTNode l, r;

    public ASTSub(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    public int eval(Environment e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        return l.eval(e) - r.eval(e);
    }

    @Override
    public void compile(Queue<String> codeBlock) {
        ASTNode.pushNodes(l, r, codeBlock, SUBTRACTION_OPERATION_COMPILER);
    }

}
