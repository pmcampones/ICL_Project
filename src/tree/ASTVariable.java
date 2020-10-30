package tree;

import environment.Environment;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTVariable implements ASTNode {

    private final String id;

    public ASTVariable(String id) {this.id = id;}

    @Override
    public int eval(Environment e) throws UndeclaredIdentifierException {
        return e.find(id);
    }
}
