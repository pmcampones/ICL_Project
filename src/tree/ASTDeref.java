package tree;

import java.io.IOException;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.operations.CheckCastOp;
import compiler.operations.GetFieldOp;
import dataTypes.*;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.NotEnoughArgumentsException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTDeref implements ASTNode {
	
	private final ASTNode node;
	
	public ASTDeref(ASTNode node) {
		this.node = node;
	}

	@Override
	public IValue eval(Environment<IValue> e)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
		IValue res = node.eval(e);
		if (res instanceof VMCell)
			return ((VMCell) res).getValue();
		throw new TypeErrorException("Cannot deref constant value");
	}

	@Override
	public void compile(CodeBlock codeBlock, Environment<Coordinates> envCoord, Environment<IType> envTypes)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {
		
		IType type = node.typeCheck(envTypes);
		assert(type instanceof TMCell);
		String className = ((TMCell) type).getRefFileName();
		
		node.compile(codeBlock, envCoord, envTypes);
		codeBlock.addOperation(new CheckCastOp(className));	
		codeBlock.addOperation(new GetFieldOp(String.format("%s/v", className), ((TMCell)type).getRefType().getCompString()));
	
	}

	@Override
	public IType typeCheck(Environment<IType> e)
			throws TypeErrorException, IDDeclaredTwiceException,
			UndeclaredIdentifierException {
		if (node.typeCheck(e) instanceof TMCell)
			return ((TMCell)node.typeCheck(e)).getReferencedType();
		throw new TypeErrorException("Dereference expression must be of type reference");
	}

}
