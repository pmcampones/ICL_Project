package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.Label;
import compiler.operations.GoToOp;
import compiler.operations.GreaterEqualOp;
import compiler.operations.LabelOp;
import compiler.operations.PushValueOp;
import compiler.operations.SubOp;
import dataTypes.IValue;
import dataTypes.TypeErrorException;
import dataTypes.VBool;
import dataTypes.VInt;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTGreaterEq implements ASTNode {

    private final ASTNode l, r;

    public ASTGreaterEq(ASTNode l, ASTNode r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public IValue eval(Environment<IValue> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException,
            TypeErrorException {
        IValue lVal, rVal;
        if ((lVal = l.eval(e)) instanceof VInt && (rVal = r.eval(e)) instanceof VInt)
            return new VBool(((VInt)lVal).getVal() >= ((VInt)rVal).getVal());
        throw new TypeErrorException("The comparison is not between numbers");
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> env) throws IDDeclaredTwiceException, UndeclaredIdentifierException {

    	Label thenLabel = new Label();
    	Label exit = new Label();
    	
    	l.compile(codeBlock, env);
    	r.compile(codeBlock, env);
    	codeBlock.addOperation(new SubOp());
    	codeBlock.addOperation(new GreaterEqualOp(thenLabel));
    	codeBlock.addOperation(new PushValueOp("0"));
    	codeBlock.addOperation(new GoToOp(exit));
    	codeBlock.addOperation(new LabelOp(thenLabel));
    	codeBlock.addOperation(new PushValueOp("1"));
    	codeBlock.addOperation(new LabelOp(exit));
    }
}
