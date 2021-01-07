package compiler.operations;

import compiler.Label;

public class SmallerOp extends Operation {
	public SmallerOp(Label label) {
		super("iflt", new String[] {label.id}, 0);
	}
}