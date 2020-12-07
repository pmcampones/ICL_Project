package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import dataTypes.IValue;
import dataTypes.TypeErrorException;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTIf implements ASTNode{

    private final ASTNode ifNode, thenNode, elseNode;

    public ASTIf(ASTNode ifNode, ASTNode thenNode, ASTNode elseNode) {
        this.ifNode   = ifNode;
        this.thenNode = thenNode;
        this.elseNode = elseNode;
    }

    //TODO
    @Override
    public IValue eval(Environment<IValue> e) throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
        return null;
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> env) throws IDDeclaredTwiceException, UndeclaredIdentifierException {

    }
}
