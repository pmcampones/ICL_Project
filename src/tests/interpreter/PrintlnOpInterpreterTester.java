package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.PrintlnOpTester.generateGlobalFunc;
import static tests.PrintlnOpTester.generateGlobalVar;
import static tests.PrintlnOpTester.generateValue;
import static tests.PrintlnOpTester.getExpectedGlobalFuncSemi;
import static tests.PrintlnOpTester.getExpectedGlobalVarFunc;
import static tests.PrintlnOpTester.getExpectedTestPrintlnAlias;
import static tests.PrintlnOpTester.getExpectedTestPrintlnChangeVarScope;
import static tests.PrintlnOpTester.getExpectedTestPrintlnGaussianSum;
import static tests.PrintlnOpTester.getExpectedTestPrintlnMinusExpression;
import static tests.PrintlnOpTester.getExpectedTestPrintlnMutabilityOrder;
import static tests.PrintlnOpTester.getExpectedTestPrintlnRunningExpressionIf;
import static tests.PrintlnOpTester.getExpectedTestPrintlnSmallerEqAttr;
import static tests.PrintlnOpTester.getExpectedTestPrintlnTwoFramesSameScope;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.NotEnoughArgumentsException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.PrintlnOpTester;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class PrintlnOpInterpreterTester extends InterpreterTester implements PrintlnOpTester {

	static boolean defined = false;

	@Override
	@Test
	public void testPrintlnMinusExpression()
			throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException,
			NotEnoughArgumentsException, IOException, InterruptedException {
		assertEquals(getExpectedTestPrintlnMinusExpression(), run());
	}

	@Override
	@Test
	public void testPrintlnMutabilityOrder() throws TypeErrorException, NotEnoughArgumentsException,
			UndeclaredIdentifierException, ParseException, IDDeclaredTwiceException, IOException, InterruptedException {
		assertEquals(getExpectedTestPrintlnMutabilityOrder(), run());
	}

	@Override
	@Test
	public void testPrintlnSmallerEqAttr() throws TypeErrorException, NotEnoughArgumentsException,
			UndeclaredIdentifierException, ParseException, IDDeclaredTwiceException, IOException, InterruptedException {
		assertEquals(getExpectedTestPrintlnSmallerEqAttr(), run());
	}

	@Override
	@Test
	public void testPrintlnTwoFramesSameScope()
			throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException,
			NotEnoughArgumentsException, IOException, InterruptedException {
		assertEquals(getExpectedTestPrintlnTwoFramesSameScope(), run());

	}

	@Override
	@Test
	public void testPrintlnGlobalFuncSemi()
			throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException,
			NotEnoughArgumentsException, IOException, InterruptedException {

		if (!defined) {
			generateGlobalFunc();
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalFuncSemi(generateValue()), run());

	}

	@Override
	@Test
	public void testPrintlnGlobalVarFunc()
			throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException,
			NotEnoughArgumentsException, IOException, InterruptedException {

		int val = generateGlobalVar();
		run();

		if (!defined) {
			generateGlobalFunc();
			defined = true;
			run();
		}

		assertEquals(getExpectedGlobalVarFunc(val), run());

	}

	@Override
	@Test
	public void testPrintlnRunningExpressionIf() throws TypeErrorException, NotEnoughArgumentsException,
			UndeclaredIdentifierException, ParseException, IDDeclaredTwiceException, IOException, InterruptedException {
		assertEquals(getExpectedTestPrintlnRunningExpressionIf(), run());
	}

	@Override
	@Test
	public void testPrintlnAlias() throws TypeErrorException, NotEnoughArgumentsException,
			UndeclaredIdentifierException, ParseException, IDDeclaredTwiceException, IOException, InterruptedException {
		assertEquals(getExpectedTestPrintlnAlias(), run());
	}

	@Override
	@Test
	public void testPrintlnChangeVarScope()
			throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException,
			NotEnoughArgumentsException, IOException, InterruptedException {
		assertEquals(getExpectedTestPrintlnChangeVarScope(), run());
	}

	@Override
	@Test
	public void testPrintlnGaussianSum() throws TypeErrorException, NotEnoughArgumentsException,
			UndeclaredIdentifierException, ParseException, IDDeclaredTwiceException, IOException, InterruptedException {
		assertEquals(getExpectedTestPrintlnGaussianSum(), run());
	}

}
