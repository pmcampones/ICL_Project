package tree;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

import compiler.CodeBlock;
import compiler.Coordinates;
import dataTypes.IType;
import dataTypes.IValue;
import dataTypes.TypeErrorException;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.NotEnoughArgumentsException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.Parser;

/**
 * MIEI
 * 
 * @author Ana Josefa Matos - 49938
 * @author Pedro Campon�s - 50051
 **/

public class ASTPrint implements ASTNode {

	private static final String TYPE_MISMATCH_MESSAGE = "Value attributed to the variable is not the expected type";

	private final String name;
	
	private final Collection<ASTNode> args;

	public ASTPrint(String name, Collection<ASTNode> args) {
		this.name = name;
		this.args = args;
	}

	@Override
	public IValue eval(Environment<IValue> prevEnv)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
		
		Function f = Parser.globalEnv.findFunc(name);
		
		Collection<Variable> fun_args = f.args;
		
		if(fun_args.size() != args.size())
			throw new NotEnoughArgumentsException(fun_args.size(), name, args.size());
		
		Environment<IValue> currEnv = prevEnv.beginScope();
        
		Iterator<Variable> it1 = fun_args.iterator();
		Iterator<ASTNode> it2 = args.iterator();

		while (it1.hasNext() && it2.hasNext()) {
		   Variable v = it1.next();
		   ASTNode exp = it2.next();
		   Optional<String> optType = v.type;
		   IValue val = exp.eval(currEnv);
		   if (optType.isPresent() && !optType.get().equals(val.getType().toString()))
       		throw new TypeErrorException(TYPE_MISMATCH_MESSAGE);
		   currEnv.assoc(v.id, val);
		   
		}
		
		return f.body.eval(currEnv);
	}

	@Override
	public void compile(CodeBlock codeBlock, Environment<Coordinates> envCoord, Environment<IType> envTypes)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {

	}

	@Override
	public IType typeCheck(Environment<IType> e)
			throws TypeErrorException, IDDeclaredTwiceException, UndeclaredIdentifierException {

		return null;
	}

}