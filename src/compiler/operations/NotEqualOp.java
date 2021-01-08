package compiler.operations;

import compiler.Label;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class NotEqualOp extends Operation {
	public NotEqualOp(Label label) {
		super("ifne", new String[] {label.id}, -1);
	}
}