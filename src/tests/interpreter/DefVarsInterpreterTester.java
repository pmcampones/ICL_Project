package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.DefVarsTester;

import static tests.DefVarsTester.*;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

public class DefVarsInterpreterTester extends InterpreterTester implements DefVarsTester {

	@Override
    @Test
    public void testDefWithoutUsingSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefWithoutUsingSimple(), run());
    }

	@Override
    @Test
    public void testDefWithoutUsingComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefWithoutUsingComplex(), run());
    }

	@Override
    @Test
    public void testDefUsingSimple() 
    		throws ParseException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefUsingSimple(), run());
    }
	
	@Override
    @Test
    public void testDefUsingComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefUsingComplex(), run());
    }

	@Override
    @Test
    public void testDefNestedSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefNestedSimple(), run());
    }

	@Override
    @Test
    public void testDefNestedCaires1()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefNestedCaires1(), run());
    }

	@Override
    @Test
    public void testDefNestedCaires2()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefNestedCaires2(), run());
    }

	@Override
    @Test
    public void testDefSameVarDifferentScopesSimple()
            throws ParseException, IDDeclaredTwiceException, 
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefSameVarDifferentScopesSimple(), run());
    }

	@Override
    @Test
    public void testDefSameVarDifferentScopesComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefSameVarDifferentScopesComplex(), run());
    }

	@Override
    @Test
    public void testDefDifferentVarsSameScope()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefDifferentVarsSameScope(), run());
    }
    
	@Override
    @Test
    public void testTwoFramesSameScope() 
    		throws ParseException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException {
    	assertEquals(getExpectedTestTwoFramesSameScope(), run());
    }

}
