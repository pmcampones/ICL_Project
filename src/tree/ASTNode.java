package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public interface ASTNode {

    int eval(Environment<Integer> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException;

    void compile(CodeBlock codeBlock, Environment<Coordinates> env) 
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException;

    static void pushNodes(ASTNode l, ASTNode r, 
    		CodeBlock codeBlock, String operation,
    		Environment<Coordinates> env) 
    				throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        l.compile(codeBlock, env);
        r.compile(codeBlock, env);
        codeBlock.addOperation(operation);
    }
    
}

