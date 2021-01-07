package compiler.operations;

public class CheckCastOp extends Operation {
	public CheckCastOp(String className) {
		super("checkcast", new String[] {className}, 0);
	}
}
