package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import dataTypes.IValue;
import dataTypes.TypeErrorException;
import dataTypes.VBool;
import dataTypes.VVoid;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTWhile implements ASTNode{

    public final ASTNode ifNode, doNode;

    public ASTWhile(ASTNode ifNode, ASTNode doNode) {
        this.ifNode = ifNode;
        this.doNode = doNode;
    }

    @Override
    public IValue eval(Environment<IValue> e) throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
        IValue result = new VVoid();
        IValue condition = ifNode.eval(e);
        while (condition instanceof VBool && ((VBool)condition).isTrue()) {
            result = doNode.eval(e);
            condition = ifNode.eval(e);
        }
        if (condition instanceof VBool)
            return result;
        throw new TypeErrorException("Reentrance condition did not evaluate as a boolean");
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> env) throws IDDeclaredTwiceException, UndeclaredIdentifierException {

    }
}
