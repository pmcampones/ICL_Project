package tests.compiler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.BoolOperationsTester.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.BoolOperationsTester;

public class BoolOperationsCompilerTester extends CompilationTester implements BoolOperationsTester {

	@Override
	@Test
	public void testBoolConstTrue() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestBoolConstTrue().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testBoolConstFalse() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestBoolConstFalse().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testDefBool() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestDefBool().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testAttrBool() 
			throws ParseException, IOException,
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestAttrBool().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testTrueEqualityInteger() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestTrueEqualityInteger().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testFalseEqualityInteger() 
			throws ParseException, IOException,
			InterruptedException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestFalseEqualityInteger().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testTrueEqualityBool()
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestTrueEqualityBool().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testFalseEqualityBool() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestFalseEqualityBool().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
		
	}

	@Override
	@Test
	public void testDefEquality() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestDefEquality().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testAttrEquality() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestAttrEquality().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
		
	}

	@Override
	@Test
	public void testGreaterTrue() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestGreaterTrue().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testGreaterFalse()
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestGreaterFalse().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testGreaterComplex() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestGreaterComplex().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testGreaterDef() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestGreaterDef().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testGreaterAttr() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestGreaterAttr().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
		
	}

	@Override
	@Test
	public void testGreaterEqBigger() 
			throws ParseException, IOException,
			InterruptedException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestGreaterEqBigger().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testGreaterEqSame() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestGreaterEqSame().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testGreaterEqSmaller() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestGreaterEqSmaller().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testGreaterEqComplex()
			throws ParseException, IOException,
			InterruptedException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestGreaterEqComplex().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testGreaterEqDef() 
			throws ParseException, IOException,
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestGreaterEqDef().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testGreaterEqAttr() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestGreaterEqAttr().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testSmallerWhenBigger()
			throws ParseException, IOException,
			InterruptedException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestSmallerWhenBigger().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testSmallerWhenEquals()
			throws ParseException, IOException,
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestSmallerWhenEquals().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testSmallerWhenSmaller() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestSmallerWhenSmaller().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testSmallerComplex() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestSmallerComplex().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testSmallerDef() 
			throws ParseException, IOException,
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestSmallerDef().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testSmallerAttr() 
			throws ParseException, IOException,
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestSmallerAttr().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testSmallerEqWhenBigger() 
			throws ParseException, IOException,
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestSmallerEqWhenBigger().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testSmallerEqWhenSame() 
			throws ParseException, IOException,
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestSmallerEqWhenSame().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testSmallerEqWhenSmaller() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestSmallerEqWhenSmaller().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName));
	}

	@Override
	@Test
	public void testSmallerEqComplex() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestSmallerEqComplex().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testSmallerEqDef() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestSmallerEqDef().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
	}

	@Override
	@Test
	public void testSmallerEqAttr() 
			throws ParseException, IOException, 
			InterruptedException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String actual = getExpectedTestSmallerEqAttr().equals("true") ? "1" : "0";
		assertEquals(actual, compileAndGetResults(methodName, 1));
	}

}
