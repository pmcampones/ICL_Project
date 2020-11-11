package tests.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import compiler.CodeBlock;
import compiler.Compiler;
import compiler.Coordinates;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import parser.Parser;

public class CompilationUtils {
	
	private static final String ASSEMBLED_FILE_DIRECTORY = "src/compiledPrograms/unitTests";
	
	static int compileAndGetResults(String methodName) 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException {
		return compileAndGetResults(methodName, 0);
	}
	
	static int compileAndGetResults(String methodName, int scopesCreated) 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException {
		String assembledFilePath = String.format("%s/%s", ASSEMBLED_FILE_DIRECTORY, methodName);
		generateAssembledFile(methodName);
		compileAssembledFile(assembledFilePath, scopesCreated);
		return runJVMCompiledFile(assembledFilePath);
	}
	
	private static void generateAssembledFile(String fileName) 
			throws ParseException, IOException, 
			IDDeclaredTwiceException, UndeclaredIdentifierException {
		CodeBlock cb = new CodeBlock();
        Parser.Start().compile(cb, new Environment<Coordinates>());
        Compiler.generateOutputFile(ASSEMBLED_FILE_DIRECTORY, fileName, cb);
	}
	
	private static void compileAssembledFile(String assembledFilePath, int scopesCreated) 
			throws IOException, InterruptedException {
		List<String> commands = new LinkedList<>();
		commands.add("java");
		commands.add("-jar");
		String programDirectory = new File(".").getCanonicalPath();
//        String jasminLocation = String.format("%s/jasmin.jar", programDirectory);
        commands.add(String.format("%s/jasmin.jar", programDirectory));
//        String assembledFullPath = String.format("%s/%s", programDirectory, methodName);
        commands.add(String.format("%s/%s", programDirectory, assembledFilePath));
//        Process compiling = new ProcessBuilder("java", "-jar", jasminLocation, assembledFullPath)
        for (int i = 0; i < scopesCreated; i++) {
        	commands.add(String.format("%s/frame_%d", ASSEMBLED_FILE_DIRECTORY, i));
        }
        Process compiling = new ProcessBuilder(commands)
        .start();
        compiling.waitFor();
	}
	
	private static int runJVMCompiledFile(String assembledFilePath) throws IOException {
		Process p = new ProcessBuilder("java", assembledFilePath).start();
        try(InputStreamReader in = new InputStreamReader(p.getInputStream());
        		BufferedReader reader = new BufferedReader(in)) {
        	return Integer.valueOf(reader.readLine());
        }
	}

}
