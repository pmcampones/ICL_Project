package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Random;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;

/**
 * MIEI
 * 
 * @author Ana Josefa Matos - 49938
 * @author Pedro Campon�s - 50051
 **/

public class SemicolonTest extends InterpreterTester {

	@Test
	public void testArithmeticSeq()
			throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
		Random r = new Random();
		int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
		String exp = String.format("%d - %d;%d + %d", first, second, first, second);
		writeToToken(exp);
		assertEquals(first + second, run());
	}

	@Test
	public void testAritmeticSeq2()
			throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
		Random r = new Random();
		int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
		int third = r.nextInt(MAX_RAND), fourth = r.nextInt(MAX_RAND);
		String exp = String.format("%d - %d;%d * %d", first, second, third, fourth);
		writeToToken(exp);
		assertEquals(third * fourth, run());
	}

	@Test
	public void testTripleAritmeticSeq()
			throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
		Random r = new Random();
		int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
		int third = r.nextInt(MAX_RAND), fourth = r.nextInt(MAX_RAND);
		int fifth = r.nextInt(MAX_RAND), sixth = r.nextInt(MAX_RAND);
		String exp = String.format("%d - %d;%d + %d;%d - %d", first, second, third, fourth, fifth, sixth);
		writeToToken(exp);
		assertEquals(fifth - sixth, run());
	}

	@Test
	public void testBracketsSeq()
			throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
		String exp = "2 * (3 + 4 * (5 + 6) - 1 * (2)); 5 * (4 - 6 * (9 + 1) - 3 * (0))";
		int val = 5 * (4 - 6 * (9 + 1) - 3 * (0));
		writeToToken(exp);
		assertEquals(val, run());
	}

	@Test
	public void testDefSeq()
			throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
		Random r = new Random();
		int attr = r.nextInt(MAX_RAND);
		int attr1 = r.nextInt(MAX_RAND), attr2 = r.nextInt(MAX_RAND);
		int[] nums = new int[3];
		for (int i = 0; i < nums.length; i++)
			nums[i] = r.nextInt(MAX_RAND);
		String exp = String.format(
				"def x = %d in def y = %d in x * (-y + x) end end; def x = %d in %d * (-x + %d * (x - %d)) end", attr1,
				attr2, attr, nums[0], nums[1], nums[2]);
		writeToToken(exp);
		int expected = nums[0] * (-attr + nums[1] * (attr - nums[2]));
		assertEquals(expected, run());
	}

	@Test
	public void testDoubleFramesSameScopeSeq()
			throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
		Random r = new Random();
		int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND), third = r.nextInt(MAX_RAND);
		String exp = String.format(
				"(%d + %d)*%d; 4 + def x = 2 y = x + 1 in x + y + def z = x + y in 2 * z end + def w = x - y in w + 2 end end",
				first, second, third);
		writeToToken(exp);
		assertEquals(20, run());
	}
	
    @Test
    public void testNewSeq()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int number = new Random().nextInt(MAX_RAND);
        int number1 = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new 5 in %d end;def x = new %d in !x end", number, number1);
        writeToToken(exp);
        assertEquals(number1, run());
    }
    
    @Test
    public void testNewSeq2()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int x = r.nextInt(MAX_RAND), y = r.nextInt(MAX_RAND);
        int z = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x end;def x = new %d y = new %d in !x + !y + def x = new !x + !y in !x * !y end end"
                , z, x, y);
        writeToToken(exp);
        assertEquals(x + y + (x + y) * y, run());
    }
    
    @Test
    public void testMultipleSemicolonsBegin()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        int number = new Random().nextInt();
        writeToToken(String.format(";;;;;;;;;;;%d", number));
        assertEquals(number, run());
    }
    
    @Test
    public void testMultipleSemicolonsEnd()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        int number = new Random().nextInt();
        writeToToken(String.format("%d;;;;;;;;;;;", number));
        assertEquals(number, run());
    }
    
	@Test
	public void testMultipleSemicolonsMiddle()
			throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException, TypeErrorException {
		Random r = new Random();
		int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
		String exp = String.format("%d - %d;;;;;;;;;;;;%d + %d", first, second, first, second);
		writeToToken(exp);
		assertEquals(first + second, run());
	}
    


}