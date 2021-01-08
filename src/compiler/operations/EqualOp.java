package compiler.operations;

import compiler.Label;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class EqualOp extends Operation {
	public EqualOp(Label label) {
		super("ifeq", new String[] {label.id}, -1);
	}
}