package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import dataTypes.IValue;
import dataTypes.TypeErrorException;
import dataTypes.VMCell;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTAttr implements ASTNode {
	
	private final ASTVariable v;
	private final ASTNode node;
	
	public ASTAttr(ASTVariable v, ASTNode node) {
		this.v = v;
		this.node = node;
	}

	@Override
	public IValue eval(Environment<IValue> e)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
		IValue updatedValue = node.eval(e);
		IValue memRef = v.eval(e);
		if(memRef instanceof VMCell) {
			((VMCell) memRef).setValue(updatedValue);
			return updatedValue;
		}
		throw new TypeErrorException("Cannot attribute value");
		
	}

	@Override
	public void compile(CodeBlock codeBlock, Environment<Coordinates> env)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException {
	
		
	}

}
