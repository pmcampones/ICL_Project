package tests.compiler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.AttrOpTester;

import static tests.AttrOpTester.*;

import java.io.IOException;

public class AttrOpCompilerTester extends CompilationTester implements AttrOpTester {

	@Override
	@Test
	public void testSimpleAttr() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestSimpleAttr(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testAttrSum() 
			throws ParseException, IOException,
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestAttrSum(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testAttrTerm() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestAttrTerm(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testAttrExpressionAfter()
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestAttrExpressionAfter(), compileAndGetResults(methodName, 2));
	}

	@Override
	@Test
	public void testNestedAttr() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestNestedAttr(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testIdentity() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestIdentity(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testNestedWithExpression() 
			throws ParseException, IOException,
			InterruptedException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();	
		assertEquals(getExpectedTestNestedWithExpression(), compileAndGetResults(methodName, 2));
	}

	@Override
	@Test
	public void testMutabilityOrder()
			throws ParseException, IOException,
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestMutabilityOrder(), compileAndGetResults(methodName, 1));
	}

}
