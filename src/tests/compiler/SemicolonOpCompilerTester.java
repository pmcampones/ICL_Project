package tests.compiler;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.NotEnoughArgumentsException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.SemicolonOpTester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.SemicolonOpTester.*;

import java.io.IOException;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class SemicolonOpCompilerTester extends CompilationTester implements SemicolonOpTester {

	@Override
	@Test
	public void testArithmeticSeq() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestArithmeticSeq(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testAritmeticSeq2()
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestAritmeticSeq2(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testTripleAritmeticSeq() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestTripleAritmeticSeq(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testBracketsSeq() 
		throws ParseException, IOException, 
		InterruptedException, IDDeclaredTwiceException, 
		UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();		
		assertEquals(getExpectedTestBracketsSeq(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testDefSeq() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();		
		assertEquals(getExpectedTestDefSeq(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testDoubleFramesSameScopeSeq() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestDoubleFramesSameScopeSeq(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testNewSeq() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();		
		assertEquals(getExpectedTestNewSeq(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testNewSeq2() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();		
		assertEquals(getExpectedTestNewSeq2(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testMultipleSemicolonsBegin() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestMultipleSemicolonsBegin(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testMultipleSemicolonsEnd() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();		
		assertEquals(getExpectedTestMultipleSemicolonsEnd(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testMultipleSemicolonsMiddle() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();		
		assertEquals(getExpectedTestMultipleSemicolonsMiddle(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testVariableDifferentSemicolon() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();		
		assertEquals(getExpectedTestVariableDifferentSemicolon(), compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testChangeVarScope() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		assertEquals(getExpectedTestChangeVarScope(), compileAndGetResults(methodName, 2));
	}

	@Override
	public void testPrintlnGlobalVarFunc()
			throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException,
			NotEnoughArgumentsException, IOException, InterruptedException {
		//TODO		
	}

}
