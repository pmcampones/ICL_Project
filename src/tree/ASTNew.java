package tree;

import java.io.IOException;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.operations.DupOp;
import compiler.operations.InvokeSpecialOp;
import compiler.operations.NewOp;
import compiler.operations.PutFieldOp;
import dataTypes.*;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTNew implements ASTNode {
	
	private final ASTNode node;
	
	public ASTNew(ASTNode node) {
		this.node = node;		
	}

	@Override
	public IValue eval(Environment<IValue> e)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
		return new VMCell(node.eval(e));
	}

	@Override
	public void compile(CodeBlock codeBlock, Environment<Coordinates> envCoord, Environment<IType> envTypes)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {
		
		IType type = node.typeCheck(envTypes);
		String className = type instanceof TMCell ? "ref_class" : "ref_int";
		
		codeBlock.addOperation(new NewOp(className));
		codeBlock.addOperation(new DupOp());
		codeBlock.addOperation(new InvokeSpecialOp(String.format("%s/<init>()V", className)));
		codeBlock.addOperation(new DupOp());
		node.compile(codeBlock, envCoord, envTypes);
		codeBlock.addOperation(new PutFieldOp(String.format("%s/v", className), type.getCompString()));		
		
	}

	@Override
	public IType typeCheck(Environment<IType> e)
			throws TypeErrorException, IDDeclaredTwiceException,
			UndeclaredIdentifierException {
		return new TMCell(node.typeCheck(e));
	}

}
