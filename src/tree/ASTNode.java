package tree;

import java.io.IOException;

import compiler.CodeBlock;
import compiler.Coordinates;
import dataTypes.IType;
import dataTypes.IValue;
import dataTypes.TypeErrorException;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.NotEnoughArgumentsException;
import environment.exceptions.UndeclaredIdentifierException;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

public interface ASTNode {

    IValue eval(Environment<IValue> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException, 
            TypeErrorException, NotEnoughArgumentsException;

    void compile(CodeBlock codeBlock, Environment<Coordinates> envCoord, Environment<IType> envTypes)
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException;

    IType typeCheck(Environment<IType> e) throws TypeErrorException, IDDeclaredTwiceException, UndeclaredIdentifierException;
    
}

