package tree.binaryArithmetic;

import java.io.IOException;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.operations.AddOp;
import dataTypes.IType;
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
* @author Pedro Campones - 50051
**/

public class ASTPlus extends ASTIntArithmetic {

    public ASTPlus(ASTNode l, ASTNode r) {
        super(l,r);
    }

    public IValue eval(Environment<IValue> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException, 
            TypeErrorException {
    	IValue lRes, rRes;
    	if ((lRes = l.eval(e)) instanceof VInt && (rRes = r.eval(e)) instanceof VInt)
    		return new VInt(((VInt)lRes).getVal() + ((VInt)rRes).getVal());
        throw new TypeErrorException("Expressions are not integers");
    }

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> envCoord, Environment<IType> envTypes)
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {
    	l.compile(cb, envCoord, envTypes);
    	r.compile(cb, envCoord, envTypes);
    	cb.addOperation(new AddOp());
    }

}

