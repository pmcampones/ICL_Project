package tests.interpreter;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import org.junit.jupiter.api.Test;
import parser.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhileInterpreterTester extends InterpreterTester {

    @Test
    public void testCountToTen()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("def x = new 0 in while !x < 10 do x := !x + 1 end end");
        assertEquals("10", run());
    }

    @Test
    public void testFibonacci()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int fibIndex = 20;
        String exp = String.format(
                "def fibIndex = %d in " +
                    "if fibIndex <= 1 then " +
                        "fibIndex " +
                    "else " +
                        "def i = new 1 x = new 0 y = new 1 in " +
                            "while !i < fibIndex do " +
                                "def aux = !x in " +
                                    "x := !y; " +
                                    "y := !y + aux " +
                                "end; " +
                                "i := !i + 1 " +
                            "end; " +
                        "!y " +
                        "end " +
                    "end " +
                "end", fibIndex);
        writeToToken(exp);
        assertEquals(String.valueOf(computeFibonacci(fibIndex)), run());

    }

    private int computeFibonacci(int fibIndex) {
        if (fibIndex <= 1) return fibIndex;
        int x = 0, y = 1;
        for (int i = 1; i < fibIndex; i++) {
            int aux = x;
            x = y;
            y += aux;
        }
        return y;
    }

}
