package compiler;

import java.util.ArrayList;
import java.util.List;

import dataTypes.IType;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class Frame {
	
	private static final String BASE_CLASS = "java/lang/Object";

	public final List<IType> varTypes;

	public final Frame parent;
	
	public final String name;

	public Frame() {
		this(0, null, BASE_CLASS);
	}
	
	public Frame(int numVariables, Frame parent, String name) {
		varTypes = new ArrayList<>(numVariables);
		this.parent = parent;
		this.name = name;
	}
	
	public void addVariableType(IType t) {
		varTypes.add(t);
	}
	
	public static boolean isBaseClass(Frame f) {
		return f.parent == null;
	}

}
