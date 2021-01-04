package tree.comparisons;

import java.io.IOException;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.Label;
import compiler.operations.GoToOp;
import compiler.operations.GreaterOp;
import compiler.operations.LabelOp;
import compiler.operations.PushValueOp;
import compiler.operations.SubOp;
import dataTypes.*;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.NotEnoughArgumentsException;
import environment.exceptions.UndeclaredIdentifierException;
import tree.ASTNode;

public class ASTGreater extends ASTComparison {

    public ASTGreater(ASTNode l, ASTNode r) {
        super(l, r);
    }

    @Override
    public IValue eval(Environment<IValue> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException,
            TypeErrorException, NotEnoughArgumentsException {
        IValue lVal, rVal;
        if ((lVal = l.eval(e)) instanceof VInt && (rVal = r.eval(e)) instanceof VInt)
            return new VBool(((VInt)lVal).getVal() > ((VInt)rVal).getVal());
        throw new TypeErrorException("The comparison is not between numbers");
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> envCoord, Environment<IType> envTypes) throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {
    	Label thenLabel = new Label();
    	Label exit = new Label();
    	
    	l.compile(codeBlock, envCoord, envTypes);
    	r.compile(codeBlock, envCoord, envTypes);
    	codeBlock.addOperation(new SubOp());
    	codeBlock.addOperation(new GreaterOp(thenLabel));
    	codeBlock.addOperation(new PushValueOp("0"));
    	codeBlock.addOperation(new GoToOp(exit));
    	codeBlock.addOperation(new LabelOp(thenLabel));
    	codeBlock.addOperation(new PushValueOp("1"));
    	codeBlock.addOperation(new LabelOp(exit));
    	
    }

}
