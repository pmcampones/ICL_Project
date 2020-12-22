package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.operations.PushValueOp;
import dataTypes.IValue;
import dataTypes.TypeErrorException;
import dataTypes.VBool;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTBool implements ASTNode {

    private final boolean val;

    public ASTBool(String strVal) {
        val = Boolean.parseBoolean(strVal);
    }

    @Override
    public IValue eval(Environment<IValue> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException,
            TypeErrorException {
        return new VBool(val);
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> env)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        if(val)
        	codeBlock.addOperation(new PushValueOp("1"));
        else
        	codeBlock.addOperation(new PushValueOp("0"));
    }
}
