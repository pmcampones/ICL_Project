package compiler.operations;

public class GetFieldOp extends Operation {
	public GetFieldOp(String fieldName, String type) {
		super("getfield", new String[] {fieldName, type}, 0);
	}
}
