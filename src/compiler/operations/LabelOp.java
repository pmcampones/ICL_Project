package compiler.operations;

import compiler.Label;

public class LabelOp extends Operation {
	public LabelOp(Label label) {
		super(String.format("%s:", label.id), new String[0], 0);
	}
}