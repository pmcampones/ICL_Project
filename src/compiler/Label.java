package compiler;

public class Label {
	
	private static final String LABEL = "L";
	private static int labelCounter = 0;
	
	public final String id;
	
	public Label() {
		id = String.format("%s%d", LABEL, labelCounter++);	
	}

}
