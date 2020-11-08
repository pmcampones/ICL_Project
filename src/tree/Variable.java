package tree;

public class Variable {
    public final String id;
    public final ASTNode exp;

    public Variable(String id, ASTNode exp) {
        this.id = id;
        this.exp = exp;
    }
}
