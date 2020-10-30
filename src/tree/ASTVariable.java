package tree;

import environment.Environment;

import java.util.Queue;

public class ASTVariable implements ASTNode {

    private final String id;

    public ASTVariable(String id) {this.id = id;}

    @Override
    public int eval(Environment e) {
        return e.find(id);
    }

    @Override
    public void compile(Queue<String> codeBlock) {

    }
}
