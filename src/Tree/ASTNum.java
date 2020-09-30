package Tree;

public class ASTNum implements ASTNode {

    private final int val;

    public ASTNum(int val) {this.val = val;}

    public int eval() {return val;}

}

