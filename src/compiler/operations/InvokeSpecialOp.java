package compiler.operations;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class InvokeSpecialOp extends Operation {
	public InvokeSpecialOp(String init) {
		super("invokespecial", new String[] {init}, -1);
	}
}
