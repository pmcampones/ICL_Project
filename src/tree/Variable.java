package tree;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Camponês - 50051
**/

public class Variable {
    public final String id;
    public final ASTNode exp;

    public Variable(String id, ASTNode exp) {
        this.id = id;
        this.exp = exp;
    }
}
