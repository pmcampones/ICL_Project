package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import dataTypes.*;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import tree.binaryArithmetic.ASTMult;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

public class ASTNeg implements ASTNode {

    private final ASTNode node;

    public ASTNeg(ASTNode node) {this.node = node;}

    @Override
    public IValue eval(Environment<IValue> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
    	IValue res = node.eval(e);
    	if (res instanceof VInt)
    		return new VInt(-((VInt)res).getVal());
    	throw new TypeErrorException("Expression is not an integer");
    }

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> env) 
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        new ASTMult(node, new ASTNum(-1)).compile(cb, env);
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
