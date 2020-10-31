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
                    "%s" +                  //CODE ENTERS HERE!!!!!
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

    public static void generateOutputFile(String filename, Queue<String> codeBlock) throws IOException {
        String code = generateCodeString(codeBlock);
        String fileContent = String.format(FILE_STUB, code);
        File f = new File(filename);
        if (f.exists())
        	FileUtils.forceDelete(f);
        try (FileWriter writer = new FileWriter(f)) {
            writer.write(fileContent);
        }
    }

    private static String generateCodeString(Queue<String> codeBlock) {
        StringBuilder builder = new StringBuilder();
        codeBlock.forEach(builder::append);
        return builder.toString();
    }

}
