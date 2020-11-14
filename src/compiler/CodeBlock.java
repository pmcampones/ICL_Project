package compiler;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
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
	private final Queue<Frame> frames = new LinkedList<>();
	
	/*
	 * Code to be written in the call stack
	 */
	private final Queue<String> callStackOperations = new LinkedList<>();
	
	private final Deque<Integer> activeFrames = new LinkedList<>();
	
	public CodeBlock() {
		activeFrames.add(-1);
	}
	
	public void addOperation(String op) {
		callStackOperations.add(op);
	}
	
	public void createFrame(int numVars) {
		int parent = activeFrames.getFirst();
		activeFrames.add(frames.size());
		frames.add(new Frame(numVars, parent));
	}
	
	public void closeFrame() {
		activeFrames.pop();
	}
	
	public int getActiveFrame() {
		return activeFrames.getFirst();
	}
	
	private String createClass(Frame frame, int nameIndex) {
		
		String staticLink = frame.parent == -1 ? "Object" : String.format("frame_%d", frame.parent); 
		
		StringBuilder builder = new StringBuilder();
		builder.append(".class public frame_").append(nameIndex).append("\n")
		.append(".super java/lang/Object\n")
		.append(".field public sl Ljava/lang/").append(staticLink).append(";\n");
		
		int numVars = frame.numVariables;
		
		for (int i = 0; i < numVars; i++) 
			builder.append(".field public v").append(i).append(" l\n");
		builder.append(INIT_METHOD);
		
		return builder.toString();
	}
	
	List<String> getFrameCode() {
		List<String> frameCode = new LinkedList<String>();
		int index = 0;
		
		for(Frame f : frames)
			frameCode.add(createClass(f, index++));
		return frameCode;
	}
	
	String getCallStackCode() {
		StringBuilder builder = new StringBuilder();
        callStackOperations.forEach(op ->
        	builder.append("\t").append(op).append("\n"));
        return builder.toString();
	}

}
