package compiler.operations;

public class PutFieldOp extends Operation {
	public PutFieldOp(String className, String field) {
		super("putfield", new String[] {className, field}, -1);
	}
}
