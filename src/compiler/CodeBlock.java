package compiler;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import compiler.operations.Operation;
import dataTypes.IType;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

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
	private final Collection<Frame> frames = new LinkedList<>();
	
	/*
	 * Code to be written in the call stack
	 */
	private final Queue<Operation> callStackOperations = new LinkedList<>();
	
	
	private final Stack<Frame> activeFrames = new Stack<>();
	
	private final String frameDirectory;
	
	/*
	 * Allows the  automated naming convention of the frames
	 */
	private int frameCounter = 0;
	
	CodeBlock(String frameDirectory) {
		assert(frameDirectory != null && !frameDirectory.equals(""));
		this.frameDirectory = frameDirectory;
		activeFrames.add(new Frame());
	}
	
	public void addOperation(Operation op) {
		callStackOperations.add(op);
	}
	
	public Frame getActiveFrame() {
		return activeFrames.peek();
	}
	
	/**
	 * Creates a new frame
	 * @param numVars The number of identifiers the frame stores
	 * @return The newly created frame
	 */
	public Frame createFrame(int numVars) {
		Frame parent = activeFrames.peek();
		String frameName = String.format("%s/frame_%d", frameDirectory, frameCounter++).replaceAll("./", "");
		Frame f = new Frame(numVars, parent, frameName);
		activeFrames.add(f);
		frames.add(f);
		return f;
	}
	
	public void closeFrame() {
		activeFrames.pop();
	}
	
	private String createClass(Frame frame) {
		assert(frame != null && frame.parent != null);
		StringBuilder builder = new StringBuilder();
		builder.append(".class public ").append(frame.name).append("\n")
		.append(".super java/lang/Object\n")
		.append(".field public sl L").append(frame.parent.name).append(";\n");
		
		int i = 0;
		for (IType t : frame.varTypes) 
			builder.append(".field public v").append(i++).append(String.format(" %s\n", t.getCompString()));
		builder.append(INIT_METHOD);
		
		return builder.toString();
	}
	
	List<String> getFrameCode() {
		assert(activeFrames.size() == 1);
		List<String> frameCode = new LinkedList<String>();
		frames.forEach(f -> frameCode.add(createClass(f)));
		return frameCode;
	}
	
	int getMaxStackSize() {
		int max = 3;
		int current = 1;
		for (Operation op : callStackOperations) {
			current += op.getStackChange();
			max = Math.max(max, current);
		}
		return max;
	}
	
	String getCallStackCode() {
		StringBuilder builder = new StringBuilder();
        callStackOperations.forEach(op ->
        	builder.append("\t").append(op.getOperationStr()).append("\n"));
        return builder.toString();
	}

}
