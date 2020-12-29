package tests.compiler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.WhileOpTester.getExpectedTestCountToTen;
import static tests.WhileOpTester.getExpectedTestFibonacci;
import static tests.WhileOpTester.getExpectedTestGaussianSum;

import java.io.IOException;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.WhileOpTester;

public class WhileOpCompilerTester extends CompilationTester implements WhileOpTester{

	@Override
	public void testCountToTen() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();		
		assertEquals(getExpectedTestCountToTen(), compileAndGetResults(methodName, 1));
	}

	@Override
	public void testFibonacci() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestFibonacci(), compileAndGetResults(methodName, 2));
	}

	@Override
	public void testGaussianSum() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestGaussianSum(), compileAndGetResults(methodName, 1));
	}

}
