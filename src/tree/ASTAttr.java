package tree;

import java.io.IOException;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.operations.CheckCastOp;
import compiler.operations.GetFieldOp;
import compiler.operations.PutFieldOp;
import dataTypes.IType;
import dataTypes.IValue;
import dataTypes.TMCell;
import dataTypes.TypeErrorException;
import dataTypes.VMCell;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTAttr implements ASTNode {

	private final ASTNode var;
	private final ASTNode value;

	public ASTAttr(ASTNode var, ASTNode value) {
		this.var = var;
		this.value = value;
	}

	@Override
	public IValue eval(Environment<IValue> e)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
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
		String className = (type instanceof TMCell) ? "ref_class" : "ref_int";
		
		this.var.compile(codeBlock, envCoord, envTypes);
		codeBlock.addOperation(new CheckCastOp(className));
		this.value.compile(codeBlock, envCoord, envTypes);
		codeBlock.addOperation(new PutFieldOp(String.format("%s/v", className), type.getCompString()));
	
		
	}

	@Override
	public IType typeCheck(Environment<IType> e)
			throws TypeErrorException, IDDeclaredTwiceException,
			UndeclaredIdentifierException {
		if (var.typeCheck(e).equals(value.typeCheck(e)))
			return value.typeCheck(e);
		throw new TypeErrorException("Variable and attributed value are of different types.");
	}

}
