package tree;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.Frame;
import compiler.operations.DupOp;
import compiler.operations.GetFieldOp;
import compiler.operations.InvokeSpecialOp;
import compiler.operations.LoadOp;
import compiler.operations.NewOp;
import compiler.operations.PopOp;
import compiler.operations.PutFieldOp;
import compiler.operations.StoreOp;
import dataTypes.IType;
import dataTypes.IValue;
import dataTypes.TBool;
import dataTypes.TInt;
import dataTypes.TMCell;
import dataTypes.TVoid;
import dataTypes.TypeErrorException;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.Parser;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

public class ASTGlobalDef implements ASTNode {

	private static final String TYPE_MISMATCH_MESSAGE =
			"Value attributed to the variable is not the expected type";

    private final Collection<Variable> variables;

    public ASTGlobalDef(Collection<Variable> variables) {
        this.variables = variables;
    }
    
    @Override
    public IValue eval(Environment<IValue> prevEnv)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException, 
            TypeErrorException {
    	
    	Environment<IValue> currEnv = prevEnv.beginScope();
        for (Variable v : variables) {
			Optional<String> optType = v.type;
        	IValue valAttr = v.exp.eval(currEnv);
        	if (optType.isPresent() && !optType.get().equals(valAttr.getType().toString()))
        		throw new TypeErrorException(TYPE_MISMATCH_MESSAGE);
        	IValue value = v.exp.eval(currEnv);
			currEnv.assoc(v.id, value);
			Parser.globalEnv.assocVar(v.id, value);
		}
       
        return null;
    }

    @Override
    public void compile(CodeBlock cb,Environment<Coordinates> envCoord, Environment<IType> envTypes)
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {

    }

	@Override
	public IType typeCheck(Environment<IType> e)
			throws TypeErrorException, IDDeclaredTwiceException, UndeclaredIdentifierException {
		
		return null;
	}


    
}