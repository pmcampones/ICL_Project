package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.GlobalVarsTester.generateGlobalFunc;
import static tests.GlobalVarsTester.generateGlobalVar;
import static tests.GlobalVarsTester.getExpectedGlobalVar;
import static tests.GlobalVarsTester.getExpectedGlobalVarDef;
import static tests.GlobalVarsTester.getExpectedGlobalVarDiv;
import static tests.GlobalVarsTester.getExpectedGlobalVarIf;
import static tests.GlobalVarsTester.getExpectedGlobalVarNew;
import static tests.GlobalVarsTester.getExpectedGlobalVarSemi;
import static tests.GlobalVarsTester.getExpectedGlobalVarSum;
import static tests.GlobalVarsTester.getExpectedGlobalVarWhile;
import static tests.GlobalVarsTester.getExpectedGlobalVarFunc;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.NotEnoughArgumentsException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.GlobalVarsTester;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/
public class GlobalVarsInterpreterTester extends InterpreterTester implements GlobalVarsTester {
	
	static int globalVar;
	static boolean defined = false;
	
	@Override
	@Test
	public void testGlobalVar() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		if(!defined) {
			int val = generateGlobalVar();
			globalVar = val;
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalVar(globalVar), run());
		
	}

	@Override
	@Test
	public void testGlobalVarSum() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		
		if(!defined) {
			int val = generateGlobalVar();
			globalVar = val;
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalVarSum(globalVar), run());
		
	}

	@Override
	@Test
	public void testGlobalVarDiv() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		
		if(!defined) {
			int val = generateGlobalVar();
			globalVar = val;
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalVarDiv(globalVar), run());
		
	}

	@Override
	@Test
	public void testGlobalVarDef() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		
		if(!defined) {
			int val = generateGlobalVar();
			globalVar = val;
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalVarDef(globalVar), run());
		
	}

	@Override
	@Test
	public void testGlobalVarIf() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		
		if(!defined) {
			int val = generateGlobalVar();
			globalVar = val;
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalVarIf(globalVar), run());
		
	}

	@Override
	@Test
	public void testGlobalVarNew() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		
		if(!defined) {
			int val = generateGlobalVar();
			globalVar = val;
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalVarNew(globalVar), run());
		
	}

	@Override
	@Test
	public void testGlobalVarWhile() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		
		if(!defined) {
			int val = generateGlobalVar();
			globalVar = val;
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalVarWhile(globalVar), run());
		
	}

	@Override
	@Test
	public void testGlobalVarSemi() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		
		if(!defined) {
			int val = generateGlobalVar();
			globalVar = val;
			defined = true;
			run();
		}
		assertEquals(getExpectedGlobalVarSemi(globalVar), run());
		
	}

	@Override
	public void testGlobalVarFunc() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException,
			TypeErrorException, NotEnoughArgumentsException, IOException, InterruptedException {
		
		if(!defined) {
			int val = generateGlobalVar();
			globalVar = val;
			defined = true;
			run();
		}
		
		generateGlobalFunc();
		run();
		
		assertEquals(getExpectedGlobalVarFunc(globalVar), run());
		
	}
	
}