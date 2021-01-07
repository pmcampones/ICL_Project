package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.WhileOpTester.getExpectedTestCountToTen;
import static tests.WhileOpTester.getExpectedTestFibonacci;
import static tests.WhileOpTester.getExpectedTestGaussianSum;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.WhileOpTester;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class WhileOpInterpreterTester extends InterpreterTester implements WhileOpTester {

	@Override
    @Test
    public void testCountToTen()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestCountToTen(), run());
    }

    //TODO Changed the sintax, now the test does not work, but the program does.
	@Override
    @Test
    public void testFibonacci()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestFibonacci(), run());

    }

    @Override
    @Test
    public void testGaussianSum()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestGaussianSum(), run());
    }

    

}
