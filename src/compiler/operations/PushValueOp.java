package compiler.operations;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class PushValueOp extends Operation {
	public PushValueOp(String argument) {
		super("sipush", new String[] {argument}, 1);
	}
}