package compiler.operations;

import compiler.Label;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class GoToOp extends Operation {
	public GoToOp(Label label) {
		super("goto", new String[] {label.id}, 0);
	}
}