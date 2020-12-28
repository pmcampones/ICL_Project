package tree;

import java.io.IOException;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.operations.PopOp;
import dataTypes.IType;
import dataTypes.IValue;
import dataTypes.TypeErrorException;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTSemi implements ASTNode {

    private final ASTNode first, second;

    public ASTSemi(ASTNode first, ASTNode second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public IValue eval(Environment<IValue> e) throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
        first.eval(e);
        return second.eval(e);
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> envCoord, Environment<IType> envTypes) throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {
    	first.compile(codeBlock, envCoord, envTypes);
    	codeBlock.addOperation(new PopOp());
    	second.compile(codeBlock, envCoord, envTypes);
    }

    @Override
    public IType typeCheck(Environment<IType> e)
            throws TypeErrorException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        first.typeCheck(e);
        return second.typeCheck(e);
    }
}
