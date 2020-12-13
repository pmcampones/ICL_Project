package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import dataTypes.IValue;
import dataTypes.TypeErrorException;
import dataTypes.VBool;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTNot implements ASTNode{

    private final ASTNode node;

    public ASTNot(ASTNode node) {
        this.node = node;
    }

    @Override
    public IValue eval(Environment<IValue> e) throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
        IValue val = node.eval(e);
        if (val instanceof VBool)
            return new VBool(!((VBool) val).isTrue());
        throw new TypeErrorException("Cannot perform 'not' operation on non boolean expressions");
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> env) throws IDDeclaredTwiceException, UndeclaredIdentifierException {

    }
}
