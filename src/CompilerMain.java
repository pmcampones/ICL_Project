import compiler.Compiler;
import environment.Environment;
import parser.Parser;
import tree.ASTNode;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class CompilerMain {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Program usage: java CompilerMain fileToCompile [directory] [framesDirectory]");
			System.out.println("If the [directory] argument is unspecified, the programs will be compiled to the directory CompiledPrograms");
			System.out.println("If the [framesDirectory] argument is unspecified the programs will be compiled to the directory Frames, under [directory]");
			System.out.println("If the user intends to keep the compiled programs in the current working directory, use ./ as the value of [directory] and [framesDirectory]");
			System.exit(0);
		}
		
		String fileName = args[0];
		new Parser(System.in);
        try {
        	ASTNode exp = Parser.Start();
        	String directory = args.length >= 2 ? args[1] : Compiler.DEFAULT_COMPILATION_DIRECTORY;
        	String frameDir = args.length >= 3 ? args[2] : Compiler.DEFAULT_FRAME_DIRECTORY;
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
