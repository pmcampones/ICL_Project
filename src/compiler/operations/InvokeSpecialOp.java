package compiler.operations;

public class InvokeSpecialOp extends Operation {
	public InvokeSpecialOp(String init) {
		super("invokespecial", new String[] {init}, -1);
	}
}
