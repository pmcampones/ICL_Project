package tests.compiler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.NewOpTester;

import static tests.NewOpTester.*;

import java.io.IOException;

public class NewOpCompilerTester extends CompilationTester implements NewOpTester {

	@Override
	@Test
	public void testNewVarTestNotUsing() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestNewVarTestNotUsing(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testNewVarUsing() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestNewVarUsing(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testNewNoDef() 
			throws ParseException, IOException,
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestNewNoDef(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testNewComplexExpression() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestNewComplexExpression(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testNewSums() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestNewSums(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testSumNewVarFirst() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestSumNewVarFirst(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testSumNewVarBoth() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestSumNewVarBoth(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testRedefineNew()
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestRedefineNew(), compileAndGetResults(methodName, 2));
	}

	@Override
	@Test
	public void testAlias()
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestAlias(), compileAndGetResults(methodName, 1));
	}

}
