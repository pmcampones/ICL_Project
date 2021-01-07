package compiler.operations;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class CheckCastOp extends Operation {
	public CheckCastOp(String className) {
		super("checkcast", new String[] {className}, 0);
	}
}
