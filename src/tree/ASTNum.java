package tree;

import environment.Environment;

public class ASTNum implements ASTNode {

    private final int val;

    public ASTNum(int val) {this.val = val;}

    public int eval(Environment e) {return val;}

}

