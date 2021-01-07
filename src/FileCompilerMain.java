import java.io.FileInputStream;
import java.io.FileNotFoundException;

import compiler.Compiler;
import environment.Environment;
import parser.Parser;
import tree.ASTNode;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/
public class FileCompilerMain {

	public static void main(String[] args) throws FileNotFoundException {
		
		if (args.length < 2) {
			System.out.println("Program usage: java CompilerMain fileToCompile targetFileName [directory] [framesDirectory]");
			System.out.println("fileToCompile:  Relative pathname of the file to be compiled");
			System.out.println("targetFileName: Name of the target compiled file");
			System.out.println("If the [directory] argument is unspecified, the programs will be compiled to the directory CompiledPrograms");
			System.out.println("If the [framesDirectory] argument is unspecified the programs will be compiled to the directory Frames, under [directory]");
			System.out.println("If the user intends to keep the compiled programs in the current working directory, use ./ as the value of [directory] and [framesDirectory]");
			System.exit(0);
		}
		
		FileInputStream in = new FileInputStream(args[0]);
		String fileName = args[1];
		new Parser(in);
        try {
        	ASTNode exp = Parser.Start();
        	String directory = args.length >= 3 ? args[2] : Compiler.DEFAULT_COMPILATION_DIRECTORY;
        	String frameDir = args.length >= 4 ? args[3] : Compiler.DEFAULT_FRAME_DIRECTORY;
            Compiler comp = new Compiler(directory, frameDir);
            exp.typeCheck(new Environment<>());
            exp.compile(comp.getCodeBlock(), new Environment<>(), new Environment<>());
            comp.generateOutputFile(fileName);
        } catch (Exception e) {
          System.err.println (e.getMessage());
          Parser.ReInit(System.in);
        }

	}

}
