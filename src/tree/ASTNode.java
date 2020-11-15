package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Camponês - 50051
**/

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

