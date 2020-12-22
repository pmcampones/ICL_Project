package compiler.operations;

import compiler.Label;

public class GoToOp extends Operation {
	public GoToOp(Label label) {
		super("goto", new String[] {label.id}, 0);
	}
}