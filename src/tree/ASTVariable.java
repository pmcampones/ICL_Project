package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.Frame;
import compiler.operations.GetFieldOp;
import compiler.operations.LoadOp;
import dataTypes.IType;
import dataTypes.IValue;
import environment.Environment;
import environment.exceptions.UndeclaredIdentifierException;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class ASTVariable implements ASTNode {

    private final String id;

    public ASTVariable(String id) {this.id = id;}

    @Override
    public IValue eval(Environment<IValue> e) throws UndeclaredIdentifierException {
        return e.find(id);
    }

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> envCoord, Environment<IType> envTypes) throws UndeclaredIdentifierException {
    	int currDepth = envCoord.getDepth();
    	Coordinates varLocation = envCoord.find(id);
    	cb.addOperation(new LoadOp());
    	Frame f = cb.getActiveFrame();
    	for (int i = currDepth; i > varLocation.depth; i--) {
    		String fieldName = String.format("%s/sl", f.name);
    		String type = String.format("L%s;", f.parent.name);
    		cb.addOperation(new GetFieldOp(fieldName, type));
    		f = f.parent;
    	}
    	String fieldName = String.format("%s/v%d", f.name, varLocation.frameIndex);
    	cb.addOperation(new GetFieldOp(fieldName, envTypes.find(id).getCompString()));
    }

	@Override
	public IType typeCheck(Environment<IType> e) throws UndeclaredIdentifierException {
		return e.find(id);
	}
}
