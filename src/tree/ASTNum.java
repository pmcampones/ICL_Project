package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.operations.PushValueOp;
import dataTypes.*;
import environment.Environment;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class ASTNum implements ASTNode {

    private final IValue val;

    public ASTNum(int val) {this.val = new VInt(val);}

    public IValue eval(Environment<IValue> e) {return val;}

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> envCoord, Environment<IType> envTypes) {
    	cb.addOperation(new PushValueOp(String.valueOf(val)));
    }

    @Override
    public IType typeCheck(Environment<IType> e) throws TypeErrorException {
        return new TInt();
    }

}

