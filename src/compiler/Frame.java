/**
 * 
 */
package compiler;

public class Frame {
	
	private static final String BASE_CLASS = "java/lang/Object";

	public final int numVariables;

	public final Frame parent;
	
	public final String name;

	public Frame() {
		this(0, null, BASE_CLASS);
	}
	
	public Frame(int numVariables, Frame parent, String name) {
		this.numVariables = numVariables;
		this.parent = parent;
		this.name = name;
	}
	
	public static boolean isBaseClass(Frame f) {
		return f.parent == null;
	}

}
