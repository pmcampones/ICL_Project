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
import dataTypes.VVoid;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.Parser;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class ASTFunc implements ASTNode {

	private static final String TYPE_MISMATCH_MESSAGE =
			"Value attributed to the variable is not the expected type";

    private final Collection<Variable> args;

    private final ASTNode body;
    
    private final String name;
    
    private final String type;

    public ASTFunc(String name, String type, Collection<Variable> args, ASTNode body) {
    	this.name = name;
    	this.type = type;
    	this.args = args;
        this.body = body;
    }
    
    @Override
    public IValue eval(Environment<IValue> prevEnv)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException, 
            TypeErrorException {
    	
    	Parser.globalEnv.assocFunc(name, new Function(name, type, args, body));
       
        return new VVoid();
    	
    }

	@Override
	public void compile(CodeBlock codeBlock, Environment<Coordinates> envCoord, Environment<IType> envTypes)
			throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException, IOException {
		//TODO
	}

	@Override
	public IType typeCheck(Environment<IType> e)
			throws TypeErrorException, IDDeclaredTwiceException, UndeclaredIdentifierException {
		//TODO
		return null;
	}

   
}