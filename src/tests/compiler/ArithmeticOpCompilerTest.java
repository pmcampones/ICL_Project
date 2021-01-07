package tests.compiler;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.ArithmeticOpTester;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static tests.ArithmeticOpTester.*;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

public class ArithmeticOpCompilerTest extends CompilationTester implements ArithmeticOpTester {

	@Override
    @Test
    public void testNumber() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestNumber(), compileAndGetResults(methodName));
    }
    
	@Override
    @Test
    public void testSum() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException {
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    	assertEquals(getExpectedTestSum(), compileAndGetResults(methodName));
    }
    
	@Override
    @Test
    public void testSub() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException {
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    	assertEquals(getExpectedTestSub(), compileAndGetResults(methodName));
    }
    
	@Override
    @Test
    public void testMult() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException {
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    	assertEquals(getExpectedTestMult(), compileAndGetResults(methodName));
    }
    
	@Override
    @Test
    public void testDiv() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException {
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    	assertEquals(getExpectedTestDiv(), compileAndGetResults(methodName));
    }

	@Override
    @Test
    public void testManySums() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException {
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestManySums(), compileAndGetResults(methodName));
    }
    
	@Override
    @Test
    public void testManySubs() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException {
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestManySubs(), compileAndGetResults(methodName));
    }
    
	@Override
    @Test
    public void testManyMults() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException {
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestManyMults(), compileAndGetResults(methodName));
    }
    
    /*
     * Cannot use very big numbers because we only test with short ints
     */
	@Override
    @Test
    public void testManyDivs() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException {
//    	int bigNum = Integer.MAX_VALUE;
//        int[] nums = getNumsArray();
//        int[] nums = {1024, 2, 2};
//    	String exp = String.format("%d / %s", bigNum, genSameOpStr(nums, "/"));
        String exp = "1024 / 2 / 2";
        writeToToken(exp);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
//        int accum = bigNum;
//        for (int num : nums) accum /= num;
        assertEquals("256", compileAndGetResults(methodName));
    }
    
	@Override
    @Test
    public void testBrackets() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestBrackets(), compileAndGetResults(methodName));
    }
    
	@Override
    @Test
    public void testBracketsSum() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestBracketsSum(), compileAndGetResults(methodName));
    }
    
	@Override
    @Test
    public void testSumsAndMultBrackets() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException,
    		UndeclaredIdentifierException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestSumsAndMultsBrackets(), compileAndGetResults(methodName));
    }
    
	@Override
    @Test
    public void testMinusSingle() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException,
    		UndeclaredIdentifierException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestMinusSingle(), compileAndGetResults(methodName));
    }
    
	@Override
    @Test
    public void testMinusTwo() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException,
    		UndeclaredIdentifierException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestMinusTwo(), compileAndGetResults(methodName));
    }
    
	@Override
    @Test
    public void testMinusExpression() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException,
    		UndeclaredIdentifierException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestMinusExpression(), compileAndGetResults(methodName));
    }
    
}
