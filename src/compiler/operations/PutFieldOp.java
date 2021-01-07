package compiler.operations;

public class PutFieldOp extends Operation {
	public PutFieldOp(String fieldName, String type) {
		super("putfield", new String[] {fieldName, type}, -2);
	}
}
