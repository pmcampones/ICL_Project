package tree;

import environment.Environment;

import java.util.Queue;

public class ASTNum implements ASTNode {

    private static final String PUSH_NUMBER_COMPILER = "sipush %d\n";

    private final int val;

    public ASTNum(int val) {this.val = val;}

    public int eval(Environment e) {return val;}

    @Override
    public void compile(Queue<String> codeBlock) {
        codeBlock.add(String.format(PUSH_NUMBER_COMPILER, val));
    }

}

