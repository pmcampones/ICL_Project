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
* @author Pedro Campon�s - 50051
**/

public class ASTPrintln implements ASTNode {

    private final ASTNode node;

    public ASTPrintln(ASTNode node) {this.node = node;}

    @Override
    public IValue eval(Environment<IValue> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
    	IValue res = node.eval(e);
    	if (res instanceof VInt)
    		System.out.println(String.format("Print: %d", ((VInt) res).getVal()));
    	return res;
    }

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> envCoord, Environment<IType> envTypes)
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {
    }

    @Override
    public IType typeCheck(Environment<IType> e)
            throws TypeErrorException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
				return null;
    	
    }

}
