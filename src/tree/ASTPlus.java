package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Camponês - 50051
**/

public class ASTPlus implements ASTNode {

    private static final String ADD_OPERATION_COMPILER = "iadd";

    private final ASTNode l, r;

    public ASTPlus(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    public int eval(Environment<Integer> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        return l.eval(e) + r.eval(e);
    }

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> env) 
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        ASTNode.pushNodes(l, r, cb, ADD_OPERATION_COMPILER, env);
    }

}

