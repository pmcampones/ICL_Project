package Tree;

public class ASTDiv implements ASTNode {

    private final ASTNode l, r;

    public ASTDiv(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    public int eval() {return l.eval() / r.eval();}

}
