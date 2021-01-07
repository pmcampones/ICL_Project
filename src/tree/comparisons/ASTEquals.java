package tree.comparisons;

import java.io.IOException;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.Label;
import compiler.operations.EqualOp;
import compiler.operations.GoToOp;
import compiler.operations.LabelOp;
import compiler.operations.PushValueOp;
import compiler.operations.SubOp;
import dataTypes.*;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import tree.ASTNode;

public class ASTEquals extends ASTComparison {

    public ASTEquals(ASTNode l, ASTNode r) {
        super(l,r);
    }

    @Override
    public IValue eval(Environment<IValue> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException,
            TypeErrorException {
        return new VBool(l.eval(e).equals(r.eval(e)));
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> envCoord, Environment<IType> envTypes)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {
    	
    	Label thenLabel = new Label();
    	Label exit = new Label();
    	
    	l.compile(codeBlock, envCoord, envTypes);
    	r.compile(codeBlock, envCoord, envTypes);
    	codeBlock.addOperation(new SubOp());
    	codeBlock.addOperation(new EqualOp(thenLabel));
    	codeBlock.addOperation(new PushValueOp("0"));
    	codeBlock.addOperation(new GoToOp(exit));
    	codeBlock.addOperation(new LabelOp(thenLabel));
    	codeBlock.addOperation(new PushValueOp("1"));
    	codeBlock.addOperation(new LabelOp(exit));
    }

}
