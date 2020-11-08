package tree;

import compiler.CodeBlock;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public interface ASTNode {

    int eval(Environment e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException;

    void compile(CodeBlock codeBlock, Environment env);

    static void pushNodes(ASTNode l, ASTNode r, 
    		CodeBlock codeBlock, String operation,
    		Environment env) {
        l.compile(codeBlock, env);
        r.compile(codeBlock, env);
        codeBlock.addOperation(operation);
    }
    
}

