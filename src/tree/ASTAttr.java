package tree;

import java.io.IOException;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.operations.CheckCastOp;
import compiler.operations.DupOp;
import compiler.operations.GetFieldOp;
import compiler.operations.PutFieldOp;
import dataTypes.IType;
import dataTypes.IValue;
import dataTypes.TMCell;
import dataTypes.TypeErrorException;
import dataTypes.VMCell;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.NotEnoughArgumentsException;
import environment.exceptions.UndeclaredIdentifierException;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class ASTAttr implements ASTNode {

	private final ASTNode var;
	private final ASTNode value;

	public ASTAttr(ASTNode var, ASTNode value) {
		this.var = var;
		this.value = value;
	}

	@Override
	public IValue eval(Environment<IValue> e)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
		IValue updatedValue = value.eval(e);
		if(var instanceof ASTVariable) {
			IValue memRef = var.eval(e);
			if(memRef instanceof VMCell) {
				((VMCell) memRef).setValue(updatedValue);
				return updatedValue;
			}
		}
		throw new TypeErrorException("Cannot attribute value");
		
	}

	@Override
	public void compile(CodeBlock codeBlock, Environment<Coordinates> envCoord, Environment<IType> envTypes)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {
		
		IType type = var.typeCheck(envTypes);
		assert(type instanceof TMCell);
		String className = ((TMCell) type).getRefFileName();
		
		this.var.compile(codeBlock, envCoord, envTypes);
		codeBlock.addOperation(new CheckCastOp(className));
		codeBlock.addOperation(new DupOp());
		this.value.compile(codeBlock, envCoord, envTypes);
		codeBlock.addOperation(new PutFieldOp(String.format("%s/v", className),
				((TMCell)type).getReferencedType().getCompString()));
		codeBlock.addOperation(new GetFieldOp(String.format("%s/v", className),
				((TMCell)type).getReferencedType().getCompString()));
	}

	@Override
	public IType typeCheck(Environment<IType> e)
			throws TypeErrorException, IDDeclaredTwiceException,
			UndeclaredIdentifierException {
		IType varType = var.typeCheck(e);
		if (!(varType instanceof TMCell))
			throw new TypeErrorException("Variable being dereferenced is not mutable");
		if (((TMCell)varType).getReferencedType().equals(value.typeCheck(e)))
			return value.typeCheck(e);
		throw new TypeErrorException("Variable and attributed value are of different types.");
	}

}
