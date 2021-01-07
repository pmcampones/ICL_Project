package compiler.operations;

import compiler.Label;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class SmallerOp extends Operation {
	public SmallerOp(Label label) {
		super("iflt", new String[] {label.id}, 0);
	}
}