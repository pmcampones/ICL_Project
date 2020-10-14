package tree;

import environment.Environment;

public class ASTSub implements ASTNode {

    private final ASTNode l, r;

    public ASTSub(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    public int eval(Environment e) {return l.eval(e) - r.eval(e);}

}
