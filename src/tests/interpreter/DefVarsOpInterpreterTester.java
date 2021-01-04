package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.*;
import parser.ParseException;
import tests.DefVarsOpTester;

import static tests.DefVarsOpTester.*;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

public class DefVarsOpInterpreterTester extends InterpreterTester implements DefVarsOpTester {

	@Override
    @Test
    public void testDefWithoutUsingSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestDefWithoutUsingSimple(), run());
    }

	@Override
    @Test
    public void testDefWithoutUsingComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestDefWithoutUsingComplex(), run());
    }

	@Override
    @Test
    public void testDefUsingSimple() 
    		throws ParseException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestDefUsingSimple(), run());
    }
	
	@Override
    @Test
    public void testDefUsingComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestDefUsingComplex(), run());
    }

	@Override
    @Test
    public void testDefNestedSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestDefNestedSimple(), run());
    }

	@Override
    @Test
    public void testDefNestedCaires1()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestDefNestedCaires1(), run());
    }

	@Override
    @Test
    public void testDefNestedCaires2()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestDefNestedCaires2(), run());
    }

	@Override
    @Test
    public void testDefSameVarDifferentScopesSimple()
            throws ParseException, IDDeclaredTwiceException, 
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestDefSameVarDifferentScopesSimple(), run());
    }

	@Override
    @Test
    public void testDefSameVarDifferentScopesComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestDefSameVarDifferentScopesComplex(), run());
    }

	@Override
    @Test
    public void testDefDifferentVarsSameScope()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestDefDifferentVarsSameScope(), run());
    }
    
	@Override
    @Test
    public void testTwoFramesSameScope() 
    		throws ParseException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
    	assertEquals(getExpectedTestTwoFramesSameScope(), run());
    }

}
