package compiler.operations;

import compiler.Label;

public class NotEqualOp extends Operation {
	public NotEqualOp(Label label) {
		super("ifne", new String[] {label.id}, -1);
	}
}