package tree;

import environment.Environment;

import java.util.Queue;

public class ASTMult implements ASTNode {

    private static final String MULTIPLY_OPERATION_COMPILER = "imul\n";

    private final ASTNode l, r;

    public ASTMult(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    @Override
    public int eval(Environment e) {return l.eval(e) * r.eval(e);}

    @Override
    public void compile(Queue<String> codeBlock) {
        ASTNode.pushNodes(l, r, codeBlock, MULTIPLY_OPERATION_COMPILER);
    }

}
