package tests;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import org.junit.jupiter.api.Test;
import parser.ParseException;

import java.io.IOException;
import java.util.Random;

import static tests.GenericTester.MAX_RAND;
import static tests.GenericTester.writeToToken;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public interface DefVarsOpTester {

    @Test
    void testDefWithoutUsingSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static String getExpectedTestDefWithoutUsingSimple() {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("def x = 1 in %d + %d end", first, second);
        writeToToken(exp);
        return String.valueOf(first + second);
    }

    @Test
    void testDefWithoutUsingComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static String getExpectedTestDefWithoutUsingComplex() {
        Random r = new Random();
        int[] nums = new int[5];
        for(int i = 0; i < nums.length; i++)
            nums[i] = r.nextInt(MAX_RAND);
        String exp = String.format("def x = 1 in %d * (-%d + %d * (%d - %d)) end",
                nums[0], nums[1], nums[2], nums[3], nums[4]);
        writeToToken(exp);
        return String.valueOf(nums[0] * (-nums[1] + nums[2] * (nums[3] - nums[4])));
    }

    @Test
    void testDefUsingSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static String getExpectedTestDefUsingSimple() {
        Random r = new Random();
        int attr = r.nextInt(MAX_RAND);
        int num = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d in x * %d end",
                attr, num);
        writeToToken(exp);
        return String.valueOf(attr * num);
    }

    @Test
    void testDefUsingComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static String getExpectedTestDefUsingComplex() {
        Random r = new Random();
        int attr = r.nextInt(MAX_RAND);
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++)
            nums[i] = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d in %d * (-x + %d * (x - %d)) end",
                attr, nums[0], nums[1], nums[2]);
        writeToToken(exp);
        return String.valueOf(nums[0] * (-attr + nums[1] * (attr  - nums[2])));
    }

    @Test
    void testDefNestedSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static String getExpectedTestDefNestedSimple() {
        Random r = new Random();
        int attr1 = r.nextInt(MAX_RAND), attr2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d in def y = %d in x * (-y + x) end end",
                attr1, attr2);
        writeToToken(exp);
        return String.valueOf(attr1 * (-attr2 + attr1));
    }

    @Test
    void testDefNestedCaires1()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static String getExpectedTestDefNestedCaires1() {
        String exp = "def x = 1 in def y = x + x in x + y end end";
        writeToToken(exp);
        return "3";
    }

    @Test
    void testDefNestedCaires2()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static String getExpectedTestDefNestedCaires2() {
        int x = 2, z = x + 1, y = z + z;
        String exp = "def x = 2 in def y = def z = x + 1 in z + z end in x * y end end";
        writeToToken(exp);
        return String.valueOf(x * y);
    }

    @Test
    void testDefSameVarDifferentScopesSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static String getExpectedTestDefSameVarDifferentScopesSimple() {
        Random r = new Random();
        int n = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d in def x = %d in x end end",
                r.nextInt(MAX_RAND), n);
        writeToToken(exp);
        return String.valueOf(n);
    }

    @Test
    void testDefSameVarDifferentScopesComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static String getExpectedTestDefSameVarDifferentScopesComplex() {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d in def y = def x = x+%d in x+x end in x * y end end",
                n1, n2);
        writeToToken(exp);
        return String.valueOf(n1 * (2 * (n1 + n2)));
    }

    @Test
    void testDefDifferentVarsSameScope()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static String getExpectedTestDefDifferentVarsSameScope() {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND),
                n3 = r.nextInt(MAX_RAND), n4 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d y = x+%d in def z = %d in def y = y+%d in x + y + z end end end",
                n1, n2, n3, n4);
        writeToToken(exp);
        return String.valueOf(n1 + (n1 + n2 + n4) + n3);
    }

    @Test
    void testTwoFramesSameScope()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException,
            IOException, InterruptedException;

    static String getExpectedTestTwoFramesSameScope() {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND),
                n3 = r.nextInt(MAX_RAND), n4 = r.nextInt(MAX_RAND),
                n5 = r.nextInt(MAX_RAND);
        String exp = String.format(
                "%d + def x = %d y = x + %d in x + y + def z = x + y in %d * z end + def w = x - y in w + %d end end",
                n1, n2, n3, n4, n5);
        writeToToken(exp);
        int x = n2;
        int y = x + n3;
        int z = x + y;
        int w = x - y;
        return String.valueOf(n1 + x + y + n4 * z + w + n5);
    }
}
