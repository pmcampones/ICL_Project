package tests;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import org.junit.jupiter.api.Test;
import parser.ParseException;

import java.io.IOException;
import java.util.Random;

import static tests.GenericTester.*;

public interface ArithmeticOpTester {

    @Test
    void testNumber()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static int getExpectedTestNumber() {
        int number = new Random().nextInt();
        writeToToken(String.valueOf(number));
        return number;
    }

    @Test
    void testSum()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static int getExpectedTestSum() {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("%d + %d", first, second);
        writeToToken(exp);
        return first + second;
    }

    @Test
    void testSub()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static int getExpectedTestSub() {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("%d - %d", first, second);
        writeToToken(exp);
        return first - second;
    }

    @Test
    void testMult()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static int getExpectedTestMult() {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("%d * %d", first, second);
        writeToToken(exp);
        return first * second;
    }

    @Test
    void testDiv()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static int getExpectedTestDiv() {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("%d / %d", first, second);
        writeToToken(exp);
        return first / second;
    }

    @Test
    void testManySums()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static int getExpectedTestManySums() {
        int[] nums = getNumsArray();
        writeToToken(genSameOpStr(nums, "+"));
        int sum = 0;
        for (int num : nums) sum += num;
        return sum;
    }

    @Test
    void testManySubs()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static int getExpectedTestManySubs() {
        int[] nums = getNumsArray();
        writeToToken(genSameOpStr(nums, "-"));
        int accum = nums[0];
        for (int i = 1; i < nums.length; i++)
            accum -= nums[i];
        return accum;
    }

    @Test
    void testManyMults()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static int getExpectedTestManyMults() {
        int[] nums = getNumsArray();
        writeToToken(genSameOpStr(nums, "*"));
        int accum = nums[0];
        for (int i = 1; i < nums.length; i++)
            accum *= nums[i];
        return accum;
    }

    @Test
    void testManyDivs()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static int getExpectedTestManyDivs() {
        int bigNum = Integer.MAX_VALUE;
        int[] nums = getNumsArray();
        String exp = String.format("%d / %s", bigNum, genSameOpStr(nums, "/"));
        writeToToken(exp);
        int accum = bigNum;
        for (int num : nums) accum /= num;
        return accum;
    }

    @Test
    void testBrackets()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static int getExpectedTestBrackets() {
        int num = new Random().nextInt();
        writeToToken(String.format("( %d )", num));
        return num;
    }

    @Test
    void testBracketsSum()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static int getExpectedTestBracketsSum() {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("(%d + %d)", first, second);
        writeToToken(exp);
        return first + second;
    }

    @Test
    void testSumsAndMultBrackets()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static int getExpectedTestSumsAndMultsBrackets() {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND), n3 = r.nextInt(MAX_RAND),
                n4 = r.nextInt(MAX_RAND), n5 = r.nextInt(MAX_RAND),
                n6 = r.nextInt(MAX_RAND), n7 = r.nextInt(MAX_RAND);
        String exp = String.format("%d * (%d + %d * (%d + %d) - %d * (%d))",
                n1, n2, n3, n4, n5, n6, n7);
        writeToToken(exp);
        return n1 * (n2 + n3 * (n4 + n5) - n6 * n7);
    }

    @Test
    void testMinusSingle()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static int getExpectedTestMinusSingle() {
        int num = new Random().nextInt();
        writeToToken(String.format("-%d", num));
        return -num;
    }

    @Test
    void testMinusTwo()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static int getExpectedTestMinusTwo() {
        Random r = new Random();
        int first = -1 * r.nextInt(), second = -1 * r.nextInt();
        String exp = String.format("-%d + %d\n", first, second);
        writeToToken(exp);
        return -first + second;
    }

    @Test
    void testMinusExpression()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static int getExpectedTestMinusExpression() {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND),
                n3 = r.nextInt(MAX_RAND), n4 = r.nextInt(MAX_RAND),
                n5 = r.nextInt(MAX_RAND), n6 = r.nextInt(MAX_RAND),
                n7 = r.nextInt(MAX_RAND);
        String exp = String.format("-(%d * (%d + %d * (%d + %d) - %d * (%d)))",
                n1, n2, n3, n4, n5, n6, n7);
        writeToToken(exp);
        return -(n1 * (n2 + n3 * (n4 + n5) - n6 * n7));
    }
}
