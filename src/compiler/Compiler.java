package compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import org.apache.commons.io.FileUtils;
 

public class Compiler {

    private static final String DEFAULT_PACKAGE = "compiledPrograms/";

    private static final String FILE_STUB =
            ".class public Demo\n" +
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
                    "	%s" +					//FRAME CLASSES
                    "\n" +
                    "	%s" +                  	//CALL STACK CODE
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

    public static void generateOutputFile(String filename, CodeBlock code) throws IOException {
        String frameCode = code.getFrameCode();
        String callStackCode = code.getCallStackCode();
        String fileContent = String.format(FILE_STUB, frameCode, callStackCode);
        File f = new File(filename);
        if (f.exists())
        	FileUtils.forceDelete(f);
        try (FileWriter writer = new FileWriter(f)) {
            writer.write(fileContent);
        }
    }

}
