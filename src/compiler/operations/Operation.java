package compiler.operations;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class Operation {

	private final String[] arguments;
	private final String opName;
	private final int stackChange;
	
	public Operation(String opName, String[] arguments, int stackChange) {
		this.opName = opName;
		this.arguments = arguments;
		this.stackChange = stackChange;
	}
	
	public int getStackChange() {
		return stackChange;
	}
	
	public String getOperationStr() {
		StringBuilder builder = new StringBuilder(opName);
		for (String arg : arguments) builder.append(" ").append(arg);
		return builder.toString();
	}
	
}