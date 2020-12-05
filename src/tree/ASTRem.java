package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.operations.DivOp;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

public class ASTRem implements ASTNode {

    private final ASTNode l, r;

    public ASTRem(ASTNode l, ASTNode r) {this.l = l; this.r = r;}

    @Override
    public int eval(Environment<Integer> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        return l.eval(e) % r.eval(e);
    }

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> env) 
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException {
    	l.compile(cb, env);
    	r.compile(cb, env);
    	cb.addOperation(new DivOp());
    }


}
