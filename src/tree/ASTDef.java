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
import environment.exceptions.NotEnoughArgumentsException;
import environment.exceptions.UndeclaredIdentifierException;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

public class ASTDef implements ASTNode {

	private static final String TYPE_MISMATCH_MESSAGE =
			"Value attributed to the variable is not the expected type";

    private final Collection<Variable> variables;

    private final ASTNode body;

    public ASTDef(Collection<Variable> variables, ASTNode body) {
        this.variables = variables;
        this.body = body;
    }
    
    @Override
    public IValue eval(Environment<IValue> prevEnv)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException, 
            TypeErrorException, NotEnoughArgumentsException {
        Environment<IValue> currEnv = prevEnv.beginScope();
        for (Variable v : variables) {
			Optional<String> optType = v.type;
        	IValue valAttr = v.exp.eval(currEnv);
        	if (optType.isPresent() && !optType.get().equals(valAttr.getType().toString()))
        		throw new TypeErrorException(TYPE_MISMATCH_MESSAGE);
			currEnv.assoc(v.id, v.exp.eval(currEnv));
		}
        return body.eval(currEnv);
    }

    @Override
    public void compile(CodeBlock cb,Environment<Coordinates> envCoord, Environment<IType> envTypes)
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {
    	Frame f = cb.createFrame(variables.size());
    	EnvPair env = compileBoilerPlate(cb, envCoord, envTypes, f);
    	assocVarsPos(cb, env.envCoord, env.envTypes, f);
    	cb.addOperation(new PopOp());
    	body.compile(cb, env.envCoord, env.envTypes);
    	closeFrame(cb, f);
    	cb.closeFrame();
    }

	private void closeFrame(CodeBlock cb, Frame currFrame) {
    	cb.addOperation(new LoadOp());
    	String fieldName = String.format("%s/sl", currFrame.name);
    	String type = String.format("L%s;", currFrame.parent.name);
    	cb.addOperation(new GetFieldOp(fieldName, type));
    	cb.addOperation(new StoreOp());

    }

    private void assocVarsPos(CodeBlock cb, Environment<Coordinates> envCoord, 
    		Environment<IType> envTypes, Frame f)
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {
    	int varIndex = 0;
    	for (Variable v : variables) {
    		cb.addOperation(new DupOp());
    		v.exp.compile(cb, envCoord, envTypes);
    		String fieldName = String.format("%s/v%d", f.name, varIndex);
    		IType type = getVariableType(v, envTypes);
    		cb.addOperation(new PutFieldOp(fieldName, type.getCompString()));
    		envCoord.assoc(v.id, new Coordinates(envCoord.getDepth(), varIndex++));
    		envTypes.assoc(v.id, type);
    		f.addVariableType(type);
    	}
    }
    
    private IType getVariableType(Variable v, Environment<IType> envTypes)
			throws TypeErrorException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, IOException {
    	Optional<String> optType = v.type;
    	if(optType.isPresent())
    		try (Scanner in = new Scanner(optType.get())) {
				return getVariableSubtype(in);
			}
    	
    	return v.exp.typeCheck(envTypes);
    }

    private IType getVariableSubtype(Scanner in) throws IOException {
    	String subtypeName = in.next();
    	switch (subtypeName) {
			case "int":
				return new TInt();
			case "bool":
				return new TBool();
			case "ref":
				return new TMCell(getVariableSubtype(in));
			default:
				return new TVoid();
		}
	}

    private EnvPair compileBoilerPlate
    		(CodeBlock cb, Environment<Coordinates> prevEnvCoord, Environment<IType> prevEnvTypes, Frame currFrame) {
    	Environment<Coordinates> currEnvCoord = prevEnvCoord.beginScope();
    	Environment<IType> currEnvTypes = prevEnvTypes.beginScope();
    	cb.addOperation(new NewOp(currFrame.name));
    	cb.addOperation(new DupOp());
    	cb.addOperation(new InvokeSpecialOp(String.format("%s/<init>()V", currFrame.name)));
    	cb.addOperation(new DupOp());
    	cb.addOperation(new LoadOp());
    	String fieldName = String.format("%s/sl", currFrame.name);
    	String type = String.format("L%s;", currFrame.parent.name);
    	cb.addOperation(new PutFieldOp(fieldName, type));
    	cb.addOperation(new DupOp());
    	cb.addOperation(new StoreOp());
    	return new EnvPair(currEnvCoord, currEnvTypes);
    }
    
    private static class EnvPair{
    	
    	private final Environment<Coordinates> envCoord;
    	private final Environment<IType> envTypes;
    	
    	private EnvPair(Environment<Coordinates> envCoord, Environment<IType> envTypes) {
    		this.envCoord = envCoord;
    		this.envTypes = envTypes;
    	}
    }

	@Override
	public IType typeCheck(Environment<IType> prevEnv)
			throws TypeErrorException, IDDeclaredTwiceException,
			UndeclaredIdentifierException {
		Environment<IType> currEnv = prevEnv.beginScope();
		for (Variable v : variables) {
			Optional<String> optType = v.type;
			IType typeAttr = v.exp.typeCheck(currEnv);
			if (optType.isPresent() && !optType.get().equals(typeAttr.toString()))
				throw new TypeErrorException(TYPE_MISMATCH_MESSAGE);
			currEnv.assoc(v.id, typeAttr);
		}
    	return body.typeCheck(currEnv);
	}
}