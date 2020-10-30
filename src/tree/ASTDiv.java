package tree;

import environment.Environment;

import java.util.Queue;

public class ASTDiv implements ASTNode {

    private static final String DIVISION_OPERATION_COMPILER = "idiv\n";

    private final ASTNode l, r;

    public ASTDiv(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    @Override
    public int eval(Environment e) {return l.eval(e) / r.eval(e);}

    @Override
    public void compile(Queue<String> codeBlock) {
        ASTNode.pushNodes(l, r, codeBlock, DIVISION_OPERATION_COMPILER);
    }


}
