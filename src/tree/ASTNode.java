package tree;

import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

import java.util.Queue;

public interface ASTNode {

    int eval(Environment e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException;

    void compile(Queue<String> codeBlock);

    static void pushNodes(ASTNode l, ASTNode r, Queue<String> codeBlock, String operation) {
        l.compile(codeBlock);
        r.compile(codeBlock);
        codeBlock.add(operation);
    }
    
}

