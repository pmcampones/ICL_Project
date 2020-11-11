package compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Queue;
import org.apache.commons.io.FileUtils;
 

public class Compiler {

    private static final String DEFAULT_PACKAGE = "compiledPrograms/";

    private static final String FILE_STUB =
            ".class public %s\n" +
                    ".super java/lang/Object\n" +
                    "\n" +
                    ";\n" +
                    "; standard initializer\n" +
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
                    "       ; setup local variables:\n" +
                    "\n" +
                    "       ;    1 - the PrintStream object held in java.lang.System.out\n" +
                    "       getstatic java/lang/System/out Ljava/io/PrintStream;\n" +
                    "\n" +
                    "       ; place your bytecodes here\n" +
                    "       ; START\n" +
                          "\n" +
                          "%s" +                  	//CODE
                    "       ; END\n" +
                    "\n" +
                    "\n" +
                    "       ; convert to String;\n" +
                    "       invokestatic java/lang/String/valueOf(I)Ljava/lang/String;\n" +
                    "       ; call println \n" +
                    "       invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n" +
                    "\n" +
                    "       return\n" +
                    "\n" +
                    ".end method";
    
    private static void writeToFile(String fileName, String fileContent) throws IOException {
    	File f = new File(fileName);
    	try(FileWriter writer = new FileWriter(f, false)) {
    		writer.write(fileContent);
    	}
    	
    }

    public static void generateOutputFile(String filename, CodeBlock code) throws IOException {
        Collection<String> frameCode = code.getFrameCode();
        
        int index = 0;
        for(String frame: frameCode) {
        	String frameName = String.format("Frame_%d", index++);
        	String frameContent = String.format(FILE_STUB, frameName, frame);
        	writeToFile(frameName, frameContent);
        }
        
        String callStackCode = code.getCallStackCode();
        String fileContent = String.format(FILE_STUB, filename, callStackCode);
        writeToFile(filename, fileContent);

    }

}
