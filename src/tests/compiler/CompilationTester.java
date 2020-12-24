package tests.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import compiler.Compiler;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import parser.Parser;
import tests.GenericTester;

import static compiler.Compiler.*;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

public class CompilationTester extends GenericTester {

	
//	private static final String ASSEMBLED_FILE_DIRECTORY = "src/compiledPrograms/unitTests";
	
	static String compileAndGetResults(String methodName) 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException {
		return compileAndGetResults(methodName, 0);
	}
	
	static String compileAndGetResults(String methodName, int scopesCreated) 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException {
//		String assembledFilePath = String.format("%s/%s", ASSEMBLED_FILE_DIRECTORY, methodName);
		Compiler comp = new Compiler(DEFAULT_COMPILATION_DIRECTORY + "/UnitTests", DEFAULT_FRAME_DIRECTORY);
		String assembledFilePath = generateAssembledFile(methodName, comp);
		compileAssembledFile(assembledFilePath, scopesCreated, comp);
		return runJVMCompiledFile(comp.codeDirectory, methodName);
	}
	
	private static String generateAssembledFile(String fileName, Compiler comp) 
			throws ParseException, IOException, 
			IDDeclaredTwiceException, UndeclaredIdentifierException {
        Parser.Start().compile(comp.getCodeBlock(), new Environment<>());
        return comp.generateOutputFile(fileName);
	}
	
	private static void compileAssembledFile(String assembledFilePath, int scopesCreated, Compiler comp)
			throws IOException, InterruptedException {
		List<String> commands = new LinkedList<>();
		commands.add("java");
		commands.add("-jar");
		String programDirectory = new File(".").getCanonicalPath();
        commands.add(String.format("%s/jasmin.jar", programDirectory));
        commands.add(String.format("%s/%s", programDirectory, assembledFilePath));
        for (int i = 0; i < scopesCreated; i++) {
        	commands.add(String.format("%s/%s/frame_%d.j", programDirectory, comp.frameDirectory, i));
        }
        Process compiling = new ProcessBuilder(commands)
        .start();
        compiling.waitFor();
        //return assembledFilePath.substring(0, assembledFilePath.length() - 1);
	}
	
	private static String runJVMCompiledFile(String directory, String file) throws IOException {
		String[] pathComponents = directory.split("/");
		StringBuilder builder = new StringBuilder();
		for (String s : pathComponents)
			builder.append(s).append(".");
		builder.append(file);
		Process p = new ProcessBuilder("java", builder.toString()).start();
        try(InputStreamReader in = new InputStreamReader(p.getInputStream());
        		BufferedReader reader = new BufferedReader(in)) {
        	return reader.readLine();
        }
	}

}
