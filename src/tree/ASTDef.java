package tree;

import java.util.Collection;

import compiler.CodeBlock;
import compiler.Coordinates;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTDef implements ASTNode {

    private final Collection<Variable> variables;

    private final ASTNode body;

    public ASTDef(Collection<Variable> variables, ASTNode body) {
        this.variables = variables;
        this.body = body;
    }
    
    @Override
    public int eval(Environment<Integer> prevEnv)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        Environment<Integer> currEnv = prevEnv.beginScope();
        for (Variable v : variables)
            currEnv.assoc(v.id, v.exp.eval(currEnv));
        return body.eval(currEnv);
    }

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> prevEnv) 
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException {
    	Environment<Coordinates> currEnv = compileBoilerPlate(cb, prevEnv);
    	cb.createFrame(variables.size());
    	assocVarsPos(cb, currEnv);
    	cb.addOperation("pop");
    	body.compile(cb, currEnv);
    	closeFrame(cb, currEnv);
    }
    
    private void closeFrame(CodeBlock cb, Environment<Coordinates> currEnv) {
    	int depth = currEnv.getDepth();
    	cb.addOperation("aload_3");
    	String prevFrame = depth == 0 ? 
    			"java/lang/Object" : "frame_" + (depth - 1);
    	cb.addOperation(String.format("getfield frame_%d/sl L%s;", depth, prevFrame));
    	cb.addOperation("astore_3");
    	
    }
    
    private void assocVarsPos(CodeBlock cb, Environment<Coordinates> env) 
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException {
    	int varIndex = 0;
    	for (Variable v : variables) {
    		cb.addOperation("dup");
    		v.exp.compile(cb, env);
    		cb.addOperation(
    				String.format("putfield frame_%d/v%d I", 
    						env.getDepth(), varIndex));
    		env.assoc(v.id, new Coordinates(env.getDepth(), varIndex++));
    	}
    }
    
    private Environment<Coordinates> compileBoilerPlate
    		(CodeBlock cb, Environment<Coordinates> prevEnv) {
    	Environment<Coordinates> currEnv = prevEnv.beginScope();
    	int depth = currEnv.getDepth();
    	cb.addOperation(String.format("new frame_%d", depth));
    	cb.addOperation("dup");
    	cb.addOperation(
    			String.format("invokespecial frame_%d/<init>()V", depth));
    	cb.addOperation("dup");
    	cb.addOperation("aload_3");
    	String prevFrame = depth == 0 ? 
    			"java/lang/Object" : "frame_" + (depth - 1);
    	cb.addOperation(
    			String.format("putfield frame_%d/sl L%s;", depth, prevFrame));
    	cb.addOperation("dup");
    	cb.addOperation("astore_3");
    	return currEnv;
    }

}