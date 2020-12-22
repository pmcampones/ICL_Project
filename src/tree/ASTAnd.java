package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import dataTypes.IValue;
import dataTypes.TypeErrorException;
import dataTypes.VBool;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTAnd implements ASTNode{

    private final ASTNode l, r;

    public ASTAnd(ASTNode l, ASTNode r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public IValue eval(Environment<IValue> e) throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
        IValue lV, rV;
        if ((lV = l.eval(e)) instanceof VBool && (rV = r.eval(e)) instanceof VBool)
            return new VBool(((VBool)lV).isTrue() && ((VBool)rV).isTrue());
        throw new TypeErrorException("Expressions aren't boolean values");
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> env) throws IDDeclaredTwiceException, UndeclaredIdentifierException {


    	
    }
}
