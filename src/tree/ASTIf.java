package tree;

import java.io.IOException;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.Label;
import compiler.operations.GoToOp;
import compiler.operations.LabelOp;
import compiler.operations.NotEqualOp;
import compiler.operations.PopOp;
import dataTypes.IType;
import dataTypes.IValue;
import dataTypes.TBool;
import dataTypes.TVoid;
import dataTypes.TypeErrorException;
import dataTypes.VBool;
import dataTypes.VVoid;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.NotEnoughArgumentsException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTIf implements ASTNode{

    private final ASTNode ifNode, thenNode, elseNode;

    public ASTIf(ASTNode ifNode, ASTNode thenNode, ASTNode elseNode) {
        this.ifNode   = ifNode;
        this.thenNode = thenNode;
        this.elseNode = elseNode;
    }

    @Override
    public IValue eval(Environment<IValue> e) throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
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
    public void compile(CodeBlock codeBlock, Environment<Coordinates> envCoord, Environment<IType> envTypes)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {
    	
    	Label thenLabel = new Label();
    	Label exit = new Label();
    	ifNode.compile(codeBlock, envCoord, envTypes);
    	codeBlock.addOperation(new NotEqualOp(thenLabel));
    	elseNode.compile(codeBlock, envCoord, envTypes);
    	if (!(elseNode.typeCheck(envTypes) instanceof TVoid))
    		codeBlock.addOperation(new PopOp());
    	codeBlock.addOperation(new GoToOp(exit));
    	codeBlock.addOperation(new LabelOp(thenLabel));
    	thenNode.compile(codeBlock, envCoord, envTypes);
    	if (!(thenNode.typeCheck(envTypes) instanceof TVoid))
    		codeBlock.addOperation(new PopOp());
    	codeBlock.addOperation(new LabelOp(exit)); 
    	
    }

    @Override
    public IType typeCheck(Environment<IType> e)
            throws TypeErrorException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        if (ifNode.typeCheck(e) instanceof TBool) {
            thenNode.typeCheck(e);
            elseNode.typeCheck(e);
            return new TVoid();
        }
        throw new TypeErrorException("If condition must be type Bool.");
    }
}
