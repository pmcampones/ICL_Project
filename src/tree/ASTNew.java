package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
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
	public void compile(CodeBlock codeBlock, Environment<Coordinates> env)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException {
		
	}

	@Override
	public IType typeCheck(Environment<IType> e)
			throws TypeErrorException, IDDeclaredTwiceException,
			UndeclaredIdentifierException {
		return new TMCell(node.typeCheck(e));
	}

}
