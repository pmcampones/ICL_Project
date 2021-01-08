package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.GlobalFuncsTester.generateValue;
import static tests.GlobalFuncsTester.generateGlobalFunc;
import static tests.GlobalFuncsTester.getExpectedGlobalFunc;
import static tests.GlobalFuncsTester.getExpectedGlobalFuncDef;
import static tests.GlobalFuncsTester.getExpectedGlobalFuncDiv;
import static tests.GlobalFuncsTester.getExpectedGlobalFuncIf;
import static tests.GlobalFuncsTester.getExpectedGlobalFuncNew;
import static tests.GlobalFuncsTester.getExpectedGlobalFuncSemi;
import static tests.GlobalFuncsTester.getExpectedGlobalFuncSum;
import static tests.GlobalFuncsTester.getExpectedGlobalFuncWhile;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.NotEnoughArgumentsException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.GlobalFuncsTester;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class GlobalFuncsInterpreterTester extends InterpreterTester implements GlobalFuncsTester {
	
	static boolean defined = false;
	
	@Override
	@Test
	public void testGlobalFunc() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		if(!defined) {
			generateGlobalFunc();
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalFunc(generateValue()), run());
		
	}

	@Override
	@Test
	public void testGlobalFuncSum() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		
		if(!defined) {
			generateGlobalFunc();
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalFuncSum(generateValue()), run());
		
	}

	@Override
	@Test
	public void testGlobalFuncDiv() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		
		if(!defined) {
			generateGlobalFunc();
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalFuncDiv(generateValue()), run());
		
	}

	@Override
	@Test
	public void testGlobalFuncDef() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		
		if(!defined) {
			generateGlobalFunc();
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalFuncDef(generateValue()), run());
		
	}

	@Override
	@Test
	public void testGlobalFuncIf() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		
		if(!defined) {
			generateGlobalFunc();
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalFuncIf(generateValue()), run());
		
	}

	@Override
	@Test
	public void testGlobalFuncNew() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		
		if(!defined) {
			generateGlobalFunc();
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalFuncNew(generateValue()), run());
		
	}

	@Override
	@Test
	public void testGlobalFuncWhile() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		
		if(!defined) {
			generateGlobalFunc();
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalFuncWhile(generateValue()), run());
		
	}

	@Override
	@Test
	public void testGlobalFuncSemi() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		
		if(!defined) {
			generateGlobalFunc();
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalFuncSemi(generateValue()), run());
		
	}
	
}