package compiler.operations;

import compiler.Label;

public class EqualOp extends Operation {
	public EqualOp(Label label) {
		super("ifeq", new String[] {label.id}, -1);
	}
}