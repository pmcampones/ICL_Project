package tree.comparisons;

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
import tree.ASTNode;

//TODO MAY HAVE TO REALLY IMPLEMENT THIS BECAUSE THE ORDER IN WHICH THE EXPRESSIONS ARE EVALUATED MAY BE IMPORTANT
public class ASTSmallerEq implements ASTNode {

    private final ASTGreaterEq node;

    public ASTSmallerEq(ASTNode l, ASTNode r) {
        node = new ASTGreaterEq(r,l);
    }

    @Override
    public IValue eval(Environment<IValue> e) throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        return node.eval(e);
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> envCoord, Environment<IType> envTypes) throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {
        node.compile(codeBlock, envCoord, envTypes);
    }

    @Override
    public IType typeCheck(Environment<IType> e)
            throws TypeErrorException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        return node.typeCheck(e);
    }
}
