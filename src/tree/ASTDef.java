package tree;

import java.util.Collection;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.Frame;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Camponês - 50051
**/

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
    	Frame f = cb.createFrame(variables.size());
    	Environment<Coordinates> currEnv = compileBoilerPlate(cb, prevEnv, f);
    	assocVarsPos(cb, currEnv, f.name);
    	cb.addOperation("pop");
    	body.compile(cb, currEnv);
    	closeFrame(cb, currEnv, f);
    	cb.closeFrame();
    }
    
    private void closeFrame(CodeBlock cb, Environment<Coordinates> currEnv, Frame currFrame) {
    	cb.addOperation("aload_1");
    	cb.addOperation(String.format("getfield %s/sl L%s;", currFrame.name, currFrame.parent.name));
    	cb.addOperation("astore_1");
    	
    }
    
    private void assocVarsPos(CodeBlock cb, Environment<Coordinates> env, String fName) 
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException {
    	int varIndex = 0;
    	for (Variable v : variables) {
    		cb.addOperation("dup");
    		v.exp.compile(cb, env);
    		cb.addOperation(
    				String.format("putfield %s/v%d I", 
    						fName, varIndex));
    		env.assoc(v.id, new Coordinates(env.getDepth(), varIndex++));
    	}
    }
    
    private Environment<Coordinates> compileBoilerPlate
    		(CodeBlock cb, Environment<Coordinates> prevEnv, Frame currFrame) {
    	Environment<Coordinates> currEnv = prevEnv.beginScope();
    	cb.addOperation(String.format("new %s", currFrame.name));
    	cb.addOperation("dup");
    	cb.addOperation(
    			String.format("invokespecial %s/<init>()V", currFrame.name));
    	cb.addOperation("dup");
    	cb.addOperation("aload_1");
    	cb.addOperation(
    			String.format("putfield %s/sl L%s;", currFrame.name, currFrame.parent.name));
    	cb.addOperation("dup");
    	cb.addOperation("astore_1");
    	return currEnv;
    }

}