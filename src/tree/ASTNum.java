package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import environment.Environment;

public class ASTNum implements ASTNode {

    private static final String PUSH_NUMBER_COMPILER = "sipush %d";

    private final int val;

    public ASTNum(int val) {this.val = val;}

    public int eval(Environment<Integer> e) {return val;}

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> env) {
        cb.addOperation(String.format(PUSH_NUMBER_COMPILER, val));
    }

}

