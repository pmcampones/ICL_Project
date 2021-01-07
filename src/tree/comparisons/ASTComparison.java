package tree.comparisons;

import dataTypes.IType;
import dataTypes.TBool;
import dataTypes.TypeErrorException;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import tree.ASTNode;

abstract class ASTComparison implements ASTNode {

    protected final ASTNode l, r;

    protected ASTComparison(ASTNode l, ASTNode r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public IType typeCheck(Environment<IType> e)
            throws TypeErrorException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        if (l.typeCheck(e).equals(r.typeCheck(e)))
            return new TBool();
        throw new TypeErrorException("Both expressions being compared must be of the same type.");
    }
}
