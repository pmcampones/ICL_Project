package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.ArithmeticOpTester;

import static tests.ArithmeticOpTester.*;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/
public class ArithmeticOpInterpreterTester extends InterpreterTester implements ArithmeticOpTester {


    @Test
    public void testNumber()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestNumber(), run());
    }

    @Test
    public void testSum()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestSum(), run());
    }

    @Test
    public void testSub()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestSub(), run());
    }

    @Test
    public void testMult()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestMult(), run());
    }

    @Test
    public void testDiv()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDiv(), run());
    }

    @Test
    public void testManySums()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestManySums(), run());
    }

    @Test
    public void testManySubs()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestManySubs(), run());
    }

    @Test
    public void testManyMults()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestManyMults(), run());
    }

    @Test
    public void testManyDivs()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestManyDivs(), run());
    }

    @Test
    public void testBrackets()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestBrackets(), run());
    }

    @Test
    public void testBracketsSum()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestBracketsSum(), run());
    }

    @Test
    public void testSumsAndMultBrackets()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestSumsAndMultsBrackets(), run());
    }

    @Test
    public void testMinusSingle()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestMinusSingle(), run());
    }

    @Test
    public void testMinusTwo()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestMinusTwo(), run());
    }

    @Test
    public void testMinusExpression()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestMinusExpression(), run());
    }

}
