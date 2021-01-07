package tests.compiler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import tests.StaticTypecheckerOpTester;

import static tests.StaticTypecheckerOpTester.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class StaticTypecheckerOpCompilerTester extends CompilationTester implements StaticTypecheckerOpTester{

	@Test
	@Override
	public void testSimpleIntExp() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestSimpleIntExp(), compileAndGetResults(methodName, 1));
	}

	@Test
	@Override
	public void testSimpleBoolExp() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String expected = getExpectedTestSimpleBoolExp().equals("true") ? "1" :"0"; 
		assertEquals(expected, compileAndGetResults(methodName, 1));
	}

	@Test
	@Override
	public void testSimpleRefExp() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();		
		assertEquals(getExpectedTestSimpleRefExp(), compileAndGetResults(methodName, 1));
	}

	@Test
	@Override
	public void testSeveralExp() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestSeveralExp(), compileAndGetResults(methodName, 1));
	}

	@Test
	@Override
	public void testChainedTypes() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestChainedTypes(), compileAndGetResults(methodName, 1));
	}

	@Test
	@Override
	public void testStaticAndDynamic() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestStaticAndDynamic(), compileAndGetResults(methodName, 1));
	}

	@Test
	@Override
	public void testDifferentScopesStatic() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestDifferentScopesStatic(), compileAndGetResults(methodName, 2));
	}

	@Test
	@Override
	public void testDifferentScopesStaticAndDynamic() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestDifferentScopesStaticAndDynamic(), compileAndGetResults(methodName, 2));
	}

}
