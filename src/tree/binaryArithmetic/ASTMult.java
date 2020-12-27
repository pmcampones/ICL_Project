package tree.binaryArithmetic;

import dataTypes.IType;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.operations.MulOp;
import dataTypes.IValue;
import dataTypes.TypeErrorException;
import dataTypes.VInt;
import tree.ASTNode;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

public class ASTMult extends ASTIntArithmetic {

    public ASTMult(ASTNode l, ASTNode r) {
        super(l,r);
    }

    @Override
    public IValue eval(Environment<IValue> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException, 
            TypeErrorException {
    	IValue lRes, rRes;
    	if ((lRes = l.eval(e)) instanceof VInt && (rRes = r.eval(e)) instanceof VInt)
    		return new VInt(((VInt)lRes).getVal() * ((VInt)rRes).getVal());
        throw new TypeErrorException("Expressions are not integers");
    }

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> envCoord, Environment<IType> envTypes)
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException {
    	l.compile(cb, envCoord, envTypes);
    	r.compile(cb, envCoord, envTypes);
    	cb.addOperation(new MulOp());
    }

}
