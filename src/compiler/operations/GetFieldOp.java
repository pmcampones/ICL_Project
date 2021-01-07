package compiler.operations;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class GetFieldOp extends Operation {
	public GetFieldOp(String fieldName, String type) {
		super("getfield", new String[] {fieldName, type}, 0);
	}
}
