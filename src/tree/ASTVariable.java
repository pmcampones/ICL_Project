package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.Frame;
import environment.Environment;
import environment.exceptions.UndeclaredIdentifierException;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Camponês - 50051
**/

public class ASTVariable implements ASTNode {

    private final String id;

    public ASTVariable(String id) {this.id = id;}

    @Override
    public int eval(Environment<Integer> e) throws UndeclaredIdentifierException {
        return e.find(id);
    }

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> env) throws UndeclaredIdentifierException {
    	int currDepth = env.getDepth();
    	Coordinates varLocation = env.find(id);
    	cb.addOperation("aload_1");
    	Frame f = cb.getActiveFrame();
    	for (int i = currDepth; i > varLocation.depth; i--) {
    		cb.addOperation(String.format("getfield %s/sl L%s;", f.name, f.parent.name));
    		f = f.parent;
    	}
    	cb.addOperation(
    			String.format("getfield %s/v%d I", f.name, varLocation.frameIndex));
    }
}
