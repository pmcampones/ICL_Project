package tree.boolArithmetic;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.operations.AndOp;
import dataTypes.*;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import tree.ASTNode;

public class ASTAnd implements ASTNode {

    private final ASTNode l, r;

    public ASTAnd(ASTNode l, ASTNode r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public IValue eval(Environment<IValue> e)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException,
            TypeErrorException {
        IValue lV, rV;
        if ((lV = l.eval(e)) instanceof VBool && (rV = r.eval(e)) instanceof VBool)
            return new VBool(((VBool)lV).isTrue() && ((VBool)rV).isTrue());
        throw new TypeErrorException("Expressions aren't boolean values");
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> env)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {
    	l.compile(codeBlock, env);
    	r.compile(codeBlock, env);
    	codeBlock.addOperation(new AndOp());
    }

    @Override
    public IType typeCheck(Environment<IType> e)
            throws TypeErrorException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        if (l.typeCheck(e) instanceof TBool && r.typeCheck(e) instanceof TBool)
            return new TBool();
        throw new TypeErrorException("AND operation requires two Bool parameters.");
    }
}
