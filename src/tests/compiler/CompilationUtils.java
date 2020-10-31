package tests.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import compiler.Compiler;
import parser.ParseException;
import parser.Parser;

public class CompilationUtils {
	
	private static final String COMPILATION_OUTPUT = "Demo";
	private static final String ASSEMBLED_FILE_PATH_STUB = "src/compiledPrograms/unitTests/%s";
	
	
	static int compileAndGetResults(String methodName) 
			throws ParseException, IOException, 
			InterruptedException {
		String assembledFilePath = String.format(ASSEMBLED_FILE_PATH_STUB, methodName);
		generateAssembledFile(assembledFilePath);
		compileAssembledFile(assembledFilePath);
		return runJVMCompiledFile();
	}
	
	private static void generateAssembledFile(String assembledFilePath) 
			throws ParseException, IOException {
		Queue<String> codeBlock = new LinkedList<>();
        Parser.Start().compile(codeBlock);
        Compiler.generateOutputFile(assembledFilePath, codeBlock);
	}
	
	private static void compileAssembledFile(String assembledFilePath) 
			throws IOException, InterruptedException {
		String programDirectory = new File(".").getCanonicalPath();
        String jasminLocation = String.format("%s/jasmin.jar", programDirectory);
        String assembledFullPath = String.format("%s/%s", programDirectory, assembledFilePath);
        Process compiling = new ProcessBuilder("java", "-jar", jasminLocation, assembledFullPath)
        .start();
        compiling.waitFor();
	}
	
	private static int runJVMCompiledFile() throws IOException {
		Process p = new ProcessBuilder("java", COMPILATION_OUTPUT).start();
        try(InputStreamReader in = new InputStreamReader(p.getInputStream());
        		BufferedReader reader = new BufferedReader(in)) {
        	return Integer.valueOf(reader.readLine());
        }
	}

}
