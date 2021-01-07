package tree.binaryArithmetic;

import dataTypes.IType;
import dataTypes.TInt;
import dataTypes.TypeErrorException;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import tree.ASTNode;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

abstract class ASTIntArithmetic implements ASTNode {

    protected ASTNode l, r;

    protected ASTIntArithmetic(ASTNode l, ASTNode r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public IType typeCheck(Environment<IType> e)
            throws TypeErrorException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        if (l.typeCheck(e) instanceof TInt && r.typeCheck(e) instanceof TInt)
            return new TInt();
        throw new TypeErrorException("Both sides of the operation must be of type Int.");
    }

}
