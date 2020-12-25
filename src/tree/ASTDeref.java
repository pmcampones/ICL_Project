package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import dataTypes.*;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTDeref implements ASTNode {
	
	private final ASTNode node;
	
	public ASTDeref(ASTNode node) {
		this.node = node;
	}

	@Override
	public IValue eval(Environment<IValue> e)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
		IValue res = node.eval(e);
		if (res instanceof VMCell)
			return ((VMCell) res).getValue();
		throw new TypeErrorException("Cannot deref constant value");
	}

	@Override
	public void compile(CodeBlock codeBlock, Environment<Coordinates> env)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException {
		
	}

	@Override
	public IType typeCheck(Environment<IType> e)
			throws TypeErrorException, IDDeclaredTwiceException {
		if (node.typeCheck(e) instanceof TMCell)
			return ((TMCell)node.typeCheck(e)).getReferencedType();
		throw new TypeErrorException("Dereference expression must be of type reference");
	}

}
