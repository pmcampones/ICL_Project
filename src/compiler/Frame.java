/**
 * 
 */
package compiler;

public class Frame {

	public final int numVariables;

	public final int parent;

	public Frame(int numVariables, int parent) {
		this.numVariables = numVariables;
		this.parent = parent;
	}

}
