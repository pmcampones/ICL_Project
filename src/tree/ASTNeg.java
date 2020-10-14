package tree;

import environment.Environment;

public class ASTNeg implements ASTNode {

    private final ASTNode node;

    public ASTNeg(ASTNode node) {this.node = node;}

    @Override
    public int eval(Environment e) {return -node.eval(e);}

}
