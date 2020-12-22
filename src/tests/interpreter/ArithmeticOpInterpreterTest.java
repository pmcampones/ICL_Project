package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.TestUtils.MAX_RAND;
import static tests.TestUtils.genSameOpStr;
import static tests.TestUtils.getNumsArray;
import static tests.TestUtils.writeToToken;
import static tests.interpreter.InterpreterTestUtil.run;

import java.io.ByteArrayInputStream;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import parser.Parser;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArithmeticOpInterpreterTest {

    public ArithmeticOpInterpreterTest() {
        new Parser(new ByteArrayInputStream(new byte[0]));
    }

    @Test
    public void testNumber()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        int number = new Random().nextInt();
        writeToToken(String.valueOf(number));
        assertEquals(number, run());
    }

    @Test
    public void testSum()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("%d + %d", first, second);
        writeToToken(exp);
        assertEquals(first + second, run());
    }

    @Test
    public void testSub()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("%d - %d", first, second);
        writeToToken(exp);
        assertEquals(first - second, run());
    }

    @Test
    public void testMult()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("%d * %d", first, second);
        writeToToken(exp);
        assertEquals(first * second, run());
    }

    @Test
    public void testDiv()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("%d / %d", first, second);
        writeToToken(exp);
        assertEquals(first / second, run());
    }

    @Test
    public void testManySums()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        int[] nums = getNumsArray();
        writeToToken(genSameOpStr(nums, "+"));
        int sum = 0;
        for (int num : nums) sum += num;
        assertEquals(sum, run());
    }

    @Test
    public void testManySubs()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        int[] nums = getNumsArray();
        writeToToken(genSameOpStr(nums, "-"));
        int accum = nums[0];
        for (int i = 1; i < nums.length; i++)
            accum -= nums[i];
        assertEquals(accum, run());
    }

    @Test
    public void testManyMults()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        int[] nums = getNumsArray();
        writeToToken(genSameOpStr(nums, "*"));
        int accum = nums[0];
        for (int i = 1; i < nums.length; i++)
            accum *= nums[i];
        assertEquals(accum, run());
    }

    @Test
    public void testManyDivs()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        int bigNum = Integer.MAX_VALUE;
        int[] nums = getNumsArray();
        String exp = String.format("%d / %s", bigNum, genSameOpStr(nums, "/"));
        writeToToken(exp);
        int accum = bigNum;
        for (int num : nums) accum /= num;
        assertEquals(accum, run());
    }

    @Test
    public void testBrackets()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        int num = new Random().nextInt();
        writeToToken(String.format("( %d )", num));
        assertEquals(num, run());
    }

    @Test
    public void testBracketsSum()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("(%d + %d)", first, second);
        writeToToken(exp);
        assertEquals(first + second, run());
    }

    @Test
    public void testSumsAndMultBrackets()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        String exp = "2 * (3 + 4 * (5 + 6) - 1 * (2))";
        int val = 2 * (3 + 4 * (5 + 6) - 1 * 2);
        writeToToken(exp);
        assertEquals(val, run());
    }

    @Test
    public void testMinusSingle()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        int num = new Random().nextInt();
        writeToToken(String.format("-%d", num));
        assertEquals(-num, run());
    }

    @Test
    public void testMinusTwo()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        Random r = new Random();
        int first = -1 * r.nextInt(), second = -1 * r.nextInt();
        String exp = String.format("-%d + %d\n", first, second);
        writeToToken(exp);
        assertEquals(-first + second, run());
    }

    @Test
    public void testMinusExpression()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        String exp = "-(2 * (3 + 4 * (5 + 6) - 1 * (2)))";
        int val = -(2 * (3 + 4 * (5 + 6) - 1 * 2));
        writeToToken(exp);
        assertEquals(val, run());
    }

}
