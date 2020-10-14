package tree;

import environment.Environment;

public class ASTMult implements ASTNode {

    private final ASTNode l, r;

    public ASTMult(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    @Override
    public int eval(Environment e) {return l.eval(e) * r.eval(e);}

}
