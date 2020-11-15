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

public class ASTNeg implements ASTNode {

    private final ASTNode node;

    public ASTNeg(ASTNode node) {this.node = node;}

    @Override
    public int eval(Environment<Integer> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        return -node.eval(e);
    }

    @Override
    public void compile(CodeBlock cb, Environment<Coordinates> env) 
    		throws IDDeclaredTwiceException, UndeclaredIdentifierException {
        new ASTMult(node, new ASTNum(-1)).compile(cb, env);
    }

}
