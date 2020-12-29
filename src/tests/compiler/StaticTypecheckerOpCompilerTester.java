package tests.compiler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import tests.StaticTypecheckerOpTester;

import static tests.StaticTypecheckerOpTester.*;

import java.io.IOException;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;

public class StaticTypecheckerOpCompilerTester extends CompilationTester implements StaticTypecheckerOpTester{

	@Override
	public void testSimpleIntExp() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestSimpleIntExp(), compileAndGetResults(methodName, 1));
	}

	@Override
	public void testSimpleBoolExp() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String expected = getExpectedTestSimpleBoolExp().equals("true") ? "1" :"0"; 
		assertEquals(expected, compileAndGetResults(methodName, 1));
	}

	@Override
	public void testSimpleRefExp() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();		
		assertEquals(getExpectedTestSimpleRefExp(), compileAndGetResults(methodName, 1));
	}

	@Override
	public void testSeveralExp() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestSeveralExp(), compileAndGetResults(methodName, 1));
	}

	@Override
	public void testChainedTypes() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestChainedTypes(), compileAndGetResults(methodName, 1));
	}

	@Override
	public void testStaticAndDynamic() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestStaticAndDynamic(), compileAndGetResults(methodName, 1));
	}

	@Override
	public void testDifferentScopesStatic() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestDifferentScopesStatic(), compileAndGetResults(methodName, 2));
	}

	@Override
	public void testDifferentScopesStaticAndDynamic() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestDifferentScopesStaticAndDynamic(), compileAndGetResults(methodName, 2));
	}

}
