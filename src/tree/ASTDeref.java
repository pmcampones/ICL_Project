package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import dataTypes.IValue;
import dataTypes.TypeErrorException;
import dataTypes.VMCell;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTDeref implements ASTNode {
	
	private final ASTVariable node;
	
	public ASTDeref(String id) {
		this.node = new ASTVariable(id);
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
	
	

}
