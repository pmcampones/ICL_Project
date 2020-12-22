package compiler.operations;

import compiler.Label;

public class GreaterOp extends Operation {
	public GreaterOp(Label label) {
		super("ifgt", new String[] {label.id}, 0);
	}
}