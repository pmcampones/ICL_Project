package tree.binaryArithmetic;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.operations.RemOp;
import dataTypes.IValue;
import dataTypes.TypeErrorException;
import dataTypes.VInt;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import tree.ASTNode;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

public class ASTRem extends ASTIntArithmetic {

    public ASTRem(ASTNode l, ASTNode r) {
        super(l,r);
    }

    @Override
    public IValue eval(Environment<IValue> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException, 
            TypeErrorException {
    	IValue lRes, rRes;
    	if ((lRes = l.eval(e)) instanceof VInt && (rRes = r.eval(e)) instanceof VInt)
    		return new VInt(((VInt)lRes).getVal() % ((VInt)rRes).getVal());
        throw new TypeErrorException("Expressions are not integers");    }

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> env) 
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException {
    	l.compile(cb, env);
    	r.compile(cb, env);
    	cb.addOperation(new RemOp());
    }

}
