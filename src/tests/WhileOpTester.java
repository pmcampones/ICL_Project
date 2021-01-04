package tests;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.*;
import parser.ParseException;

import static tests.GenericTester.writeToToken;
import static tests.GenericTester.MAX_RAND;

import java.io.IOException;
import java.util.Random;

public interface WhileOpTester {

	@Test
	void testCountToTen()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestCountToTen() {
		writeToToken("def x = new 0 in while !x < 10 do x := !x + 1 end; !x end");
		return "10";
	}
	
	@Test
	void testFibonacci()
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestFibonacci() {
		int fibIndex = new Random().nextInt(MAX_RAND);
        String exp = String.format(
                "def fibIndex = %d result = new 0 in " +
                    "if fibIndex <= 1 then " +
                        "result := fibIndex " +
                    "else " +
                        "def i = new 1 x = new 0 y = new 1 in " +
                            "while !i < fibIndex do " +
                                "def aux = !x in " +
                                    "x := !y; " +
                                    "y := !y + aux " +
                                "end; " +
                                "i := !i + 1 " +
                            "end; " +
                            "result := !y " +
                        "end " +
                    "end; " +
                    "!result " +
                "end", fibIndex);
        writeToToken(exp);
        return String.valueOf(computeFibonacci(fibIndex));
	}
	
	private static int computeFibonacci(int fibIndex) {
        if (fibIndex <= 1) return fibIndex;
        int x = 0, y = 1;
        for (int i = 1; i < fibIndex; i++) {
            int aux = x;
            x = y;
            y += aux;
        }
        return y;
    }
	
	@Test
	void testGaussianSum()
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestGaussianSum() {
		int limit = new Random().nextInt(MAX_RAND);
        String exp = String.format(
                "def i = new 0 sum = new 0 in " +
                    "while !i < %d do " +
                        "i := !i + 1; " +
                        "sum := !sum + !i " +
                    "end; " +
                    "!sum " +
                "end", limit);
        writeToToken(exp);
        return String.valueOf(computeGaussianSum(limit));
	}
	
	private static int computeGaussianSum(int limit) {
        int sum = 0;
        for (int i = 0; i <= limit; i++)
            sum += i;
        return sum;
    }
	
}
