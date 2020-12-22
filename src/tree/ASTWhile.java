package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.Label;
import compiler.operations.GoToOp;
import compiler.operations.LabelOp;
import compiler.operations.NotEqualOp;
import compiler.operations.PushValueOp;
import compiler.operations.SubOp;
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
        IValue condition = ifNode.eval(e);
        while (condition instanceof VBool && ((VBool)condition).isTrue()) {
            doNode.eval(e);
            condition = ifNode.eval(e);
        }
        if (condition instanceof VBool)
            return new VVoid();
        throw new TypeErrorException("Reentrance condition did not evaluate as a boolean");
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> env) throws IDDeclaredTwiceException, UndeclaredIdentifierException {
    	
    	Label beforeCond = new Label();
    	Label exit = new Label();
    	codeBlock.addOperation(new LabelOp(beforeCond));
    	ifNode.compile(codeBlock, env);
    	codeBlock.addOperation(new PushValueOp("1"));
    	codeBlock.addOperation(new SubOp());
    	codeBlock.addOperation(new NotEqualOp(exit));
    	doNode.compile(codeBlock, env);
    	codeBlock.addOperation(new GoToOp(beforeCond));
    	codeBlock.addOperation(new LabelOp(exit)); 
    	
    }
}
