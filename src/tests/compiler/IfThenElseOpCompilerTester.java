package tests.compiler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.IfThenElseOpTester;

import static tests.IfThenElseOpTester.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class IfThenElseOpCompilerTester extends CompilationTester implements IfThenElseOpTester{

	@Override
	@Test
	public void testSimpleExpressionTrue()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName(); 
		assertEquals(getExpectedTestSimpleExpressionTrue(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testSimpleExpressionFalse()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName(); 
		assertEquals(getExpectedTestSimpleExpressionFalse(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testElseExpressionTrue()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName(); 
		assertEquals(getExpectedTestElseExpressionTrue(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testElseExpressionFalse()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName(); 
		assertEquals(getExpectedTestElseExpressionFalse(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testExpressionScopeIf()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName(); 
		assertEquals(getExpectedTestExpressionScopeIf(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testRunningExpressionIf()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName(); 
		assertEquals(getExpectedTestRunningExpressionIf(), compileAndGetResults(methodName, 1));
	}

}
