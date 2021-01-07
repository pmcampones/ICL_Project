package compiler.operations;

import compiler.Label;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class LabelOp extends Operation {
	public LabelOp(Label label) {
		super(String.format("%s:", label.id), new String[0], 0);
	}
}