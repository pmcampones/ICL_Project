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

    @Test
    public void testDefWithoutUsingSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefWithoutUsingSimple(), run());
    }

    @Test
    public void testDefWithoutUsingComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefWithoutUsingComplex(), run());
    }

    @Test
    public void testDefUsingSimple() 
    		throws ParseException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefUsingSimple(), run());
    }

    @Test
    public void testDefUsingComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefUsingComplex(), run());
    }

    @Test
    public void testDefNestedSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefNestedSimple(), run());
    }

    @Test
    public void testDefNestedCaires1()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefNestedCaires1(), run());
    }

    @Test
    public void testDefNestedCaires2()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefNestedCaires2(), run());
    }

    @Test
    public void testDefSameVarDifferentScopesSimple()
            throws ParseException, IDDeclaredTwiceException, 
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefSameVarDifferentScopesSimple(), run());
    }

    @Test
    public void testDefSameVarDifferentScopesComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefSameVarDifferentScopesComplex(), run());
    }

    @Test
    public void testDefDifferentVarsSameScope()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDefDifferentVarsSameScope(), run());
    }
    
    @Test
    public void testTwoFramesSameScope() 
    		throws ParseException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException {
    	assertEquals(getExpectedTestTwoFramesSameScope(), run());
    }

}
