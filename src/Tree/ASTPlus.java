package Tree;

public class ASTPlus implements ASTNode {

    private final ASTNode l, r;

    public ASTPlus(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    public int eval() {return l.eval() + r.eval();}

}

