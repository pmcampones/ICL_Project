package compiler.operations;

import compiler.Label;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class GreaterOp extends Operation {
	public GreaterOp(Label label) {
		super("ifgt", new String[] {label.id}, 0);
	}
}