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

public class ASTDiv implements ASTNode {

    private static final String DIVISION_OPERATION_COMPILER = "idiv";

    private final ASTNode l, r;

    public ASTDiv(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    @Override
    public int eval(Environment<Integer> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        return l.eval(e) / r.eval(e);
    }

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> env) 
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        ASTNode.pushNodes(l, r, cb, DIVISION_OPERATION_COMPILER, env);
    }


}
