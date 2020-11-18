package compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

public class Compiler {
	
	public static final String DEFAULT_COMPILATION_DIRECTORY = "CompiledPrograms";
	
	public static final String DEFAULT_FRAME_DIRECTORY = "Frames";

    private static final String FILE_STUB =
            ".class public %s\n" +
                    ".super java/lang/Object\n" +
                    ".method public <init>()V\n" +
                    "   aload_0\n" +
                    "   invokenonvirtual java/lang/Object/<init>()V\n" +
                    "   return\n" +
                    ".end method\n" +
                    "\n" +
                    ".method public static main([Ljava/lang/String;)V\n" +
                    "       ; set limits used by this method\n" +
                    "       .limit locals  2\n" +
                    "       .limit stack 256\n" +
                    "\n" +
                    "       ;    1 - the PrintStream object held in java.lang.System.out\n" +
                    "       getstatic java/lang/System/out Ljava/io/PrintStream;\n" +
                    "\n" +
                    "	new java/lang/Object\n" +
                    "	dup\n" +
                    "	invokespecial java/lang/Object/<init>()V\n" +
                    "	astore_1\n" +
                    "%s" +						//CODE
                    "\n" +
                    "       ; convert to String;\n" +
                    "       invokestatic java/lang/String/valueOf(I)Ljava/lang/String;\n" +
                    "       ; call println \n" +
                    "       invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n" +
                    "\n" +
                    "       return\n" +
                    "\n" +
                    ".end method";
    
    private final CodeBlock cb;
    
    public final String codeDirectory;
    
    public final String frameDirectory;
    
    
    
    public Compiler() {
    	this(DEFAULT_COMPILATION_DIRECTORY, DEFAULT_FRAME_DIRECTORY);
    }
    
    public Compiler(String codeDirectory, String frameDirectory) {
    	this.codeDirectory = codeDirectory;
    	this.frameDirectory = String.format("%s/%s", 
    			codeDirectory, frameDirectory);
    	new File(this.frameDirectory).mkdirs();
    	cb = new CodeBlock(this.frameDirectory);
    }
    
    private static void writeToFile(String filePath, String fileContent) throws IOException {
    	File f = new File(filePath);
    	try(FileWriter writer = new FileWriter(f, false)) {
    		writer.write(fileContent);
    	}
    	
    }
    
    /**
     * Compiles a program given its name
     * @param fileName The name of the file to be compiled
     * @return The pathname of the file relative to the project root
     */
    public String generateOutputFile(String fileName) throws IOException {
        Collection<String> frameCode = cb.getFrameCode();
        int index = 0;
        for(String frame: frameCode) {
        	String framePath = String.format("%s/frame_%d.j", frameDirectory, index++);
        	writeToFile(framePath, frame);
        }
        
        String callStackCode = cb.getCallStackCode();
        String className = String.format("%s/%s", codeDirectory, fileName);
        String fileContent = String.format(FILE_STUB, className, callStackCode);
        String filePath = String.format("%s.j", className);
        writeToFile(filePath, fileContent);
        return filePath;
    }
    
    public CodeBlock getCodeBlock() {
    	return cb;
    }

}
