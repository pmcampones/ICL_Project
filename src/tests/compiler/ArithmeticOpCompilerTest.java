package tests.compiler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import parser.ParseException;
import parser.Parser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.TestUtils.*;
import static tests.compiler.CompilationUtils.compileAndGetResults;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArithmeticOpCompilerTest {

    public ArithmeticOpCompilerTest() {
        new Parser(new ByteArrayInputStream(new byte[0]));
    }

    @Test
    public void testNumber() 
    		throws ParseException, IOException, 
    		InterruptedException {
        int number = new Random().nextInt(MAX_RAND);
        writeToToken(String.valueOf(number));
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(number, compileAndGetResults(methodName));
    }
    
    @Test
    public void testSum() 
    		throws ParseException, IOException, 
    		InterruptedException {
    	Random r = new Random();
    	int[] nums = {r.nextInt(MAX_RAND), r.nextInt(MAX_RAND)};
    	writeToToken(genSameOpStr(nums, "+"));
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    	assertEquals(nums[0] + nums[1], compileAndGetResults(methodName));
    }
    
    @Test
    public void testSub() 
    		throws ParseException, IOException, 
    		InterruptedException {
    	Random r = new Random();
    	int[] nums = {r.nextInt(MAX_RAND), r.nextInt(MAX_RAND)};
    	writeToToken(genSameOpStr(nums, "-"));
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    	assertEquals(nums[0] - nums[1], compileAndGetResults(methodName));
    }
    
    @Test
    public void testMult() 
    		throws ParseException, IOException, 
    		InterruptedException {
    	Random r = new Random();
    	int[] nums = {r.nextInt(MAX_RAND), r.nextInt(MAX_RAND)};
    	writeToToken(genSameOpStr(nums, "*"));
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    	assertEquals(nums[0] * nums[1], compileAndGetResults(methodName));
    }
    
    @Test
    public void testDiv() 
    		throws ParseException, IOException, 
    		InterruptedException {
    	Random r = new Random();
    	int[] nums = {r.nextInt(MAX_RAND), r.nextInt(MAX_RAND)};
    	writeToToken(genSameOpStr(nums, "/"));
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    	assertEquals(nums[0] / nums[1], compileAndGetResults(methodName));
    }

    @Test
    public void testManySums() 
    		throws ParseException, IOException, 
    		InterruptedException {
    	int[] nums = getNumsArray();
    	writeToToken(genSameOpStr(nums, "+"));
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    	int sum = 0;
        for (int num : nums) sum += num;
        assertEquals(sum, compileAndGetResults(methodName));
    }
    
    @Test
    public void testManySubs() 
    		throws ParseException, IOException, 
    		InterruptedException {
    	int[] nums = getNumsArray();
    	writeToToken(genSameOpStr(nums, "-"));
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    	int accum = nums[0];
    	for (int i = 1; i < nums.length; i++)
    		accum -= nums[i];
        assertEquals(accum, compileAndGetResults(methodName));
    }
    
    @Test
    public void testManyMults() 
    		throws ParseException, IOException, 
    		InterruptedException {
    	int[] nums = getNumsArray();
    	writeToToken(genSameOpStr(nums, "*"));
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    	int accum = 1;
        for (int num : nums) accum *= num;
        assertEquals(accum, compileAndGetResults(methodName));
    }
    
    /*
     * Cannot use very big numbers because we only test with short ints
     */
    @Test
    public void testManyDivs() 
    		throws ParseException, IOException, 
    		InterruptedException {
    	int bigNum = Integer.MAX_VALUE;
//        int[] nums = getNumsArray();
        int[] nums = {1024, 2, 2};
//    	String exp = String.format("%d / %s", bigNum, genSameOpStr(nums, "/"));
        String exp = "1024 / 2 / 2";
        writeToToken(exp);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        int accum = bigNum;
        for (int num : nums) accum /= num;
        assertEquals(256, compileAndGetResults(methodName));
    }
    
    @Test
    public void testBrackets() 
    		throws ParseException, IOException, 
    		InterruptedException {
    	int num = new Random().nextInt(MAX_RAND);
        writeToToken(String.format("( %d )", num));
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(num, compileAndGetResults(methodName));
    }
    
    @Test
    public void testBracketsSum() 
    		throws ParseException, IOException, 
    		InterruptedException {
    	Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("(%d + %d)", first, second);
        writeToToken(exp);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(first + second, compileAndGetResults(methodName));
    }
    
    @Test
    public void testSumsAndMultBrackets() 
    		throws ParseException, IOException, 
    		InterruptedException {
    	String exp = "2 * (3 + 4 * (5 + 6) - 1 * (2))";
        int val = 2 * (3 + 4 * (5 + 6) - 1 * 2);
        writeToToken(exp);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(val, compileAndGetResults(methodName));
    }
    
    @Test
    public void testMinusSingle() 
    		throws ParseException, IOException, 
    		InterruptedException {
    	int num = new Random().nextInt(MAX_RAND);
        writeToToken(String.format("-%d", num));
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(-num, compileAndGetResults(methodName));
    }
    
    @Test
    public void testMinusTwo() 
    		throws ParseException, IOException, 
    		InterruptedException {
    	Random r = new Random();
        int first = -1 * r.nextInt(MAX_RAND), second = -1 * r.nextInt(MAX_RAND);
        String exp = String.format("-%d + %d\n", first, second);
        writeToToken(exp);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(-first + second, compileAndGetResults(methodName));
    }
    
    @Test
    public void testMinusExpression() 
    		throws ParseException, IOException, 
    		InterruptedException {
    	String exp = "-(2 * (3 + 4 * (5 + 6) - 1 * (2)))";
        int val = -(2 * (3 + 4 * (5 + 6) - 1 * 2));
        writeToToken(exp);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(val, compileAndGetResults(methodName));
    }
    
}
