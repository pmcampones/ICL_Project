package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import environment.Environment;
import environment.exceptions.UndeclaredIdentifierException;

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
    	cb.addOperation("aload_3");
    	for (int i = currDepth; i > varLocation.depth; i--) 
    		cb.addOperation(String.format("getfield frame_%d/sl Lframe_%d;", i, i - 1));
    	cb.addOperation(
    			String.format("getfield frame_%d/v%d I", varLocation.depth, varLocation.frameIndex));
    }
}
