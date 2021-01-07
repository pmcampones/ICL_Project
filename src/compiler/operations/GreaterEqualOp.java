package compiler.operations;

import compiler.Label;

public class GreaterEqualOp extends Operation {
	public GreaterEqualOp(Label label) {
		super("ifge", new String[] {label.id}, 0);
	}
}