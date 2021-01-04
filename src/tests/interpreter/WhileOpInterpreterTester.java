package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.WhileOpTester.*;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.*;
import parser.ParseException;
import tests.WhileOpTester;

public class WhileOpInterpreterTester extends InterpreterTester implements WhileOpTester {

	@Override
    @Test
    public void testCountToTen()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestCountToTen(), run());
    }

    //TODO Changed the sintax, now the test does not work, but the program does.
	@Override
    @Test
    public void testFibonacci()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestFibonacci(), run());

    }

    @Override
    @Test
    public void testGaussianSum()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestGaussianSum(), run());
    }

    

}
