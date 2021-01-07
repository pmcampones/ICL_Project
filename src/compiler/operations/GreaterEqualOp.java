package compiler.operations;

import compiler.Label;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class GreaterEqualOp extends Operation {
	public GreaterEqualOp(Label label) {
		super("ifge", new String[] {label.id}, 0);
	}
}