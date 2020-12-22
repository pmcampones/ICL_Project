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

public class ASTIf implements ASTNode{

    private final ASTNode ifNode, thenNode, elseNode;

    public ASTIf(ASTNode ifNode, ASTNode thenNode, ASTNode elseNode) {
        this.ifNode   = ifNode;
        this.thenNode = thenNode;
        this.elseNode = elseNode;
    }

    @Override
    public IValue eval(Environment<IValue> e) throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
        IValue ifVal = ifNode.eval(e);
        if (ifVal instanceof VBool) {
            if(((VBool) ifVal).isTrue())
                thenNode.eval(e);
            else elseNode.eval(e);
            return new VVoid();
        }
        throw new TypeErrorException("The condition did not evaluate to a boolean");
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> env) throws IDDeclaredTwiceException, UndeclaredIdentifierException {

    }
}
