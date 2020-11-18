package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.operations.PushValueOp;
import environment.Environment;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

public class ASTNum implements ASTNode {

    private final int val;

    public ASTNum(int val) {this.val = val;}

    public int eval(Environment<Integer> e) {return val;}

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> env) {
    	cb.addOperation(new PushValueOp(String.valueOf(val)));
    }

}

