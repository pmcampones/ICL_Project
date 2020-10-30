package tree;

import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public interface ASTNode {

    int eval(Environment e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException;
	
}

