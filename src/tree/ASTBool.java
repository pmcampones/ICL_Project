package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.operations.PushValueOp;
import dataTypes.IType;
import dataTypes.IValue;
import dataTypes.TBool;
import dataTypes.VBool;
import environment.Environment;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class ASTBool implements ASTNode {

    private final boolean val;

    public ASTBool(String strVal) {
        val = Boolean.parseBoolean(strVal);
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return new VBool(val);
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> envCoord, Environment<IType> envTypes) {
        if(val)
        	codeBlock.addOperation(new PushValueOp("1"));
        else
        	codeBlock.addOperation(new PushValueOp("0"));
    }

    @Override
    public IType typeCheck(Environment<IType> e) {
        return new TBool();
    }
}
