package tree;

import environment.Environment;

public class ASTPlus implements ASTNode {

    private final ASTNode l, r;

    public ASTPlus(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    public int eval(Environment e) {return l.eval(e) + r.eval(e);}

}
