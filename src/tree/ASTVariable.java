package tree;

import environment.Environment;

public class ASTVariable implements ASTNode {

    private final String id;

    public ASTVariable(String id) {this.id = id;}

    @Override
    public int eval(Environment e) {
        return e.find(id);
    }
}
