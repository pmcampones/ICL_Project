package compiler.operations;

public class NewOp extends Operation {
	public NewOp(String className) {
		super("new", new String[] {className}, 1);
	}
}
