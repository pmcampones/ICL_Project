package tree;

import compiler.CodeBlock;
import compiler.Coordinates;
import dataTypes.IValue;
import dataTypes.TypeErrorException;
import dataTypes.VBool;
import dataTypes.VInt;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

public class ASTGreater implements ASTNode {

    private final ASTNode l, r;

    public ASTGreater(ASTNode l, ASTNode r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public IValue eval(Environment<IValue> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException,
            TypeErrorException {
        IValue lVal, rVal;
        if ((lVal = l.eval(e)) instanceof VInt && (rVal = r.eval(e)) instanceof VInt)
            return new VBool(((VInt)lVal).getVal() > ((VInt)rVal).getVal());
        throw new TypeErrorException("The comparison is not between numbers");
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> env) throws IDDeclaredTwiceException, UndeclaredIdentifierException {

    }
}
