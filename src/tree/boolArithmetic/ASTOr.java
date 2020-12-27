package tree.boolArithmetic;

import compiler.CodeBlock;
import compiler.Coordinates;
import compiler.operations.OrOp;
import dataTypes.IType;
import dataTypes.IValue;
import dataTypes.TypeErrorException;
import dataTypes.VBool;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import tree.ASTNode;

public class ASTOr extends ASTBoolArithmetic implements ASTNode {

    public ASTOr(ASTNode l, ASTNode r) {
        super(l, r);
    }

    @Override
    public IValue eval(Environment<IValue> e) throws IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
        IValue lV, rV;
        if ((lV = l.eval(e)) instanceof VBool && (rV = r.eval(e)) instanceof VBool)
            return new VBool(((VBool)lV).isTrue() && ((VBool)rV).isTrue());
        throw new TypeErrorException("Expressions aren't boolean values");
    }

    @Override
    public void compile(CodeBlock codeBlock, Environment<Coordinates> envCoord, Environment<IType> envTypes)
            throws IDDeclaredTwiceException, UndeclaredIdentifierException {
    	l.compile(codeBlock, envCoord, envTypes);
    	r.compile(codeBlock, envCoord, envTypes);
    	codeBlock.addOperation(new OrOp());	
    }
}
