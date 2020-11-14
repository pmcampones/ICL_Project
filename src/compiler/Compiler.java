package compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
 
public class Compiler {


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
    
    private static void writeToFile(String filePath, String fileContent) throws IOException {
    	File f = new File(filePath);
    	try(FileWriter writer = new FileWriter(f, false)) {
    		writer.write(fileContent);
    	}
    	
    }

    public static void generateOutputFile(String fileDirectory, String fileName, CodeBlock code) throws IOException {
        Collection<String> frameCode = code.getFrameCode();
        
        int index = 0;
        for(String frame: frameCode) {
        	String frameName = String.format("frame_%d", index++);
//        	String frameContent = String.format(frame, fileDirectory);
//        	writeToFile(frameName, frameContent);
        	writeToFile(frameName, frame);
        }
        
        String callStackCode = code.getCallStackCode();
//        String filePath = String.format("%s/%s", fileDirectory, fileName);
//        String fileContent = String.format(FILE_STUB, filePath, callStackCode);
        String fileContent = String.format(FILE_STUB, fileName, callStackCode);
        writeToFile(fileName, fileContent);

    }

}
