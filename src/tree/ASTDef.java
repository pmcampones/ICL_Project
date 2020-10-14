package tree;

import environment.Environment;

public class ASTDef implements ASTNode {

    private final String id;

    private final ASTNode init;

    private final ASTNode body;

    private final Environment env;

    public ASTDef(String id, ASTNode init, ASTNode body, Environment env) {
        this.id = id;
        this.init = init;
        this.body = body;
        this.env = env;
    }

    public int eval(Environment e) {
        int inVal = init.eval(e);
        e.beginScope();
        e.assoc(id, inVal);
        int bodVal = body.eval(e);
        e.endScope();
        return bodVal;
    }
}