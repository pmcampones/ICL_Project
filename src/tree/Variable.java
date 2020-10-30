package tree;

import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class Variable {
    public final String id;
    public final ASTNode exp;

    public Variable(String id, ASTNode exp) {
        this.id = id;
        this.exp = exp;
    }
}
