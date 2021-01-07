package compiler.operations;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class NewOp extends Operation {
	public NewOp(String className) {
		super("new", new String[] {className}, 1);
	}
}
