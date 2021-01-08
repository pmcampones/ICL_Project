package tree.boolArithmetic;

import dataTypes.IType;
import dataTypes.TBool;
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

abstract class ASTBoolArithmetic implements ASTNode {

    protected final ASTNode l, r;

    protected ASTBoolArithmetic(ASTNode l, ASTNode r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public IType typeCheck(Environment<IType> e)
            throws TypeErrorException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        if (l.typeCheck(e) instanceof TBool && r.typeCheck(e) instanceof  TBool)
            return new TBool();
        throw new TypeErrorException("Both expressions must be of type Bool");
    }

}
