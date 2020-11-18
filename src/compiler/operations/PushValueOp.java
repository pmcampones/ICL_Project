package compiler.operations;

public class PushValueOp extends Operation {
	public PushValueOp(String argument) {
		super("sipush", new String[] {argument}, 1);
	}
}