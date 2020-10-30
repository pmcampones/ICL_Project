package tree;

import environment.Environment;

import java.util.Queue;

public interface ASTNode {

    int eval(Environment e);

    void compile(Queue<String> codeBlock);

    static void pushNodes(ASTNode l, ASTNode r, Queue<String> codeBlock, String operation) {
        l.compile(codeBlock);
        r.compile(codeBlock);
        codeBlock.add(operation);
    }
	
}

