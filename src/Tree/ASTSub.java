package Tree;

public class ASTSub implements ASTNode {

    private final ASTNode l, r;

    public ASTSub(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    public int eval() {return l.eval() - r.eval();}

}
