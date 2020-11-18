package compiler.operations;

public class GetFieldOp extends Operation {
	public GetFieldOp(String className, String field) {
		super("getfield", new String[] {className, field}, 0);
	}
}
