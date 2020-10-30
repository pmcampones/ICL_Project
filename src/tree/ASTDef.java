package tree;

import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import tree.exceptions.VariableValueAssociatedWithUnprocessedExpressionException;

import java.util.Collection;
import java.util.Queue;

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
    public void compile(Queue<String> codeBlock) {

    }

}