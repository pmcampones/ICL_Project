package tree;

import java.util.Collection;

import compiler.CodeBlock;
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
    public int eval(Environment prevEnv)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        Environment currEnv = prevEnv.beginScope();
        for (Variable v : variables)
            currEnv.assoc(v.id, v.exp.eval(currEnv));
        return body.eval(currEnv);
    }

    @Override
    public void compile(CodeBlock cb, Environment prevEnv) {
    	Environment currEnv = compileBoilerPlate(cb, prevEnv);
    	assocVarsPos(cb, currEnv);
    	cb.addOperation("pop");
    	body.compile(cb, currEnv);
    	//TODO POP currEnv
    }
    
    private void assocVarsPos(CodeBlock cb, Environment env) {
    	int varIndex = 0;
    	for (Variable v : variables) {
    		cb.addOperation("dup");
    		v.exp.compile(cb, env);
    		cb.addOperation(
    				String.format("putfield frame_%d v%d l", 
    						env.getDepth(), varIndex++));
    	}
    }
    
    private Environment compileBoilerPlate
    		(CodeBlock cb, Environment prevEnv) {
    	Environment currEnv = prevEnv.beginScope();
    	int depth = currEnv.getDepth();
    	cb.addOperation(String.format("new frame_%d", depth));
    	cb.addOperation("dup");
    	cb.addOperation(
    			String.format("invokespecial frame_%d/<init>()V\n", depth));
    	cb.addOperation("dup");
    	cb.addOperation("aload_3");
    	cb.addOperation(
    			String.format("putfield frame_%d", depth));
    	String prevFrame = depth == 0 ? 
    			"java/lang/Object" : "frame_" + (depth - 1);
    	cb.addOperation(
    			String.format("/sl L%s", prevFrame));
    	cb.addOperation("dup");
    	cb.addOperation("astore_3");
    	return currEnv;
    }

}