package compiler.operations;

public class DupOp extends Operation {
	public DupOp(String opName, String[] arguments, int stackChange) {
		super("dup", new String[0], 1);
	}
}
