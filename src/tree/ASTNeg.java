package tree;

import java.io.IOException;

import compiler.CodeBlock;
import compiler.Coordinates;
import dataTypes.*;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.NotEnoughArgumentsException;
import environment.exceptions.UndeclaredIdentifierException;
import tree.binaryArithmetic.ASTMult;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class ASTNeg implements ASTNode {

    private final ASTNode node;

    public ASTNeg(ASTNode node) {this.node = node;}

    @Override
    public IValue eval(Environment<IValue> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
    	IValue res = node.eval(e);
    	if (res instanceof VInt)
    		return new VInt(-((VInt)res).getVal());
    	throw new TypeErrorException("Expression is not an integer");
    }

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> envCoord, Environment<IType> envTypes)
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {
        new ASTMult(node, new ASTNum(-1)).compile(cb, envCoord, envTypes);
    }

    @Override
    public IType typeCheck(Environment<IType> e)
            throws TypeErrorException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        if (node.typeCheck(e) instanceof TInt)
            return new TInt();
        throw new TypeErrorException("Unary negative requires a type Int.");
    }

}
