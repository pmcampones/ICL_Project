package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import dataTypes.*;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTVoid implements ASTNode{

    @Override
    public IValue eval(Environment<IValue> e) throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
        return new VVoid();
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> envCoord, Environment<IType> envTypes)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {}

    @Override
    public IType typeCheck(Environment<IType> e) {
        return new TVoid();
    }
}
