package Tree;

public class ASTMult implements ASTNode {

    private final ASTNode l, r;

    public ASTMult(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    @Override
    public int eval() {return l.eval() * r.eval();}

}
