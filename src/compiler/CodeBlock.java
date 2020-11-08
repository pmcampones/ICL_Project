package compiler;

import java.util.LinkedList;
import java.util.Queue;

public class CodeBlock {
	
	private static final String INIT_METHOD =
					"\n.method public <init>()V\n" +
					"aload_0\n" + 
					"invokenonvirtual java/lang/Object/<init>()V\n" +
					"return\n" +
					".end method\n";
	
	/*
	 * Number of variables per frame.
	 * First frame has a static link to java/lang/Object
	 * 	all other have a link to the previous frame.
	 * 	Naming convention is "frame_X" with X = position of the frame in the queue.
	 */
	private final Queue<Integer> frames = new LinkedList<>();
	
	/*
	 * Code to be written in the call stack
	 */
	private final Queue<String> callStackOperations = new LinkedList<>();
	
	public void addOperation(String op) {
		callStackOperations.add(String.format("%s\n", op));
	}
	
	public void createFrame(int numVars) {
		frames.add(numVars);
	}
	
	private String createClass(String staticLink, int numVars, int nameIndex) {
		StringBuilder builder = new StringBuilder();
		builder.append(".class public frame_").append(nameIndex).append("\n")
		.append(".super java/lang/Object\n")
		.append(".field public sl Ljava/lang/").append(staticLink).append(";\n");
		
		for (int i = 0; i < numVars; i++) 
			builder.append(".field public v").append(i).append(" l\n");
		builder.append(INIT_METHOD);
		
		return builder.toString();
	}
	
	String getFrameCode() {
		if (frames.isEmpty())
			return "";
		int index = 0;
		StringBuilder builder = new StringBuilder();
		int firstFrameVars = frames.poll();
		builder.append(createClass("Object", firstFrameVars, index++));
		while (!frames.isEmpty())
			builder.append("\n").append(createClass("frame_" + index, frames.poll(), index++));
		return builder.toString();
	}
	
	String getCallStackCode() {
		StringBuilder builder = new StringBuilder();
        callStackOperations.forEach(builder::append);
        return builder.toString();
	}

}
