package compiler.operations;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class PutFieldOp extends Operation {
	public PutFieldOp(String fieldName, String type) {
		super("putfield", new String[] {fieldName, type}, -2);
	}
}
