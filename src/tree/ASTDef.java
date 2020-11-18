package tree;

import java.util.Collection;

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
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
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
    	cb.addOperation(new PopOp());
    	body.compile(cb, currEnv);
    	closeFrame(cb, currEnv, f);
    	cb.closeFrame();
    }
    
    private void closeFrame(CodeBlock cb, Environment<Coordinates> currEnv, Frame currFrame) {
    	cb.addOperation(new LoadOp());
    	String fieldName = String.format("%s/sl", currFrame.name);
    	String type = String.format("L%s;", currFrame.parent.name);
    	cb.addOperation(new GetFieldOp(fieldName, type));
    	cb.addOperation(new StoreOp());
    	
    }
    
    private void assocVarsPos(CodeBlock cb, Environment<Coordinates> env, String fName) 
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException {
    	int varIndex = 0;
    	for (Variable v : variables) {
    		cb.addOperation(new DupOp());
    		v.exp.compile(cb, env);
    		String fieldName = String.format("%s/v%d", fName, varIndex);
    		cb.addOperation(new PutFieldOp(fieldName, "I"));
    		env.assoc(v.id, new Coordinates(env.getDepth(), varIndex++));
    	}
    }
    
    private Environment<Coordinates> compileBoilerPlate
    		(CodeBlock cb, Environment<Coordinates> prevEnv, Frame currFrame) {
    	Environment<Coordinates> currEnv = prevEnv.beginScope();
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
    	return currEnv;
    }

}