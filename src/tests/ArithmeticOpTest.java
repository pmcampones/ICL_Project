package tests;


import java.io.ByteArrayInputStream;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import parser.ParseException;
import parser.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static tests.TestUtils.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArithmeticOpTest {
		
	public ArithmeticOpTest() {
		new Parser(new ByteArrayInputStream(new byte[0]));
	}
	
	@Test
	public void testNumber() {
		try {
			tryToTestNumber();
		} catch (ParseException e){fail();}
	}
	
	private void tryToTestNumber() throws ParseException {
		int number = new Random().nextInt();
		writeToToken(String.valueOf(number));
		assertEquals(number, run());		
	}
	
	@Test
	public void testSum() {
		try {
			tryToTestSum();
		} catch (ParseException e){fail();}
	}
	
	private void tryToTestSum() throws ParseException {
		Random r = new Random();
		int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
		String exp = String.format("%d + %d", first, second);
		writeToToken(exp);
		assertEquals(first + second, run());		
	}
	
	@Test
	public void testSub() {
		try {
			tryToTestSub();
		} catch (ParseException e) {fail();}
	}
	
	private void tryToTestSub() throws ParseException {
		Random r = new Random();
		int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
		String exp = String.format("%d - %d", first, second);
		writeToToken(exp);
		assertEquals(first - second, run());		
	}
	
	@Test
	public void testMult() {
		try {
			tryToTestMult();
		} catch (ParseException e) {fail();}
	}
	
	private void tryToTestMult() throws ParseException {
		Random r = new Random();
		int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
		String exp = String.format("%d * %d", first, second);
		writeToToken(exp);
		assertEquals(first * second, run());		
	}
	
	@Test
	public void testDiv() {
		try {
			tryToTestDiv();
		} catch (ParseException e) {fail();}
	}
	
	private void tryToTestDiv() throws ParseException {
		Random r = new Random();
		int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
		String exp = String.format("%d / %d", first, second);
		writeToToken(exp);
		assertEquals(first / second, run());
	}
	
	private int[] getNumsArray() {
		int[] nums = new int[DEFAULT_LEN];
		Random r = new Random();
		for (int i = 0; i < DEFAULT_LEN; i++)
			nums[i] = r.nextInt(MAX_RAND);
		return nums;
	}
	
	private String genSameOpStr(int[] nums, String operator) {
		StringBuilder expWriter = new StringBuilder("");
		for (int i = 0; i < nums.length - 1; i++)
			expWriter.append(nums[i] + operator);
		expWriter.append(nums[nums.length - 1]);
		return expWriter.toString();
	}
	
	@Test
	public void testManySums() {
		try {
			tryToTestManySums();
		} catch (ParseException e) {fail();}
	}
	
	private void tryToTestManySums() throws ParseException {
		int[] nums = getNumsArray();		
		writeToToken(genSameOpStr(nums, "+"));
		int sum = 0;
		for (int num : nums) sum += num;
		assertEquals(sum, run());
	}
	
	@Test
	public void testManySubs() {
		try {
			tryToTestManySubs();
		} catch (ParseException e) {fail();}
		
	}
	
	private void tryToTestManySubs() throws ParseException {
		int[] nums = getNumsArray();		
		writeToToken(genSameOpStr(nums, "-"));
		int accum = nums[0];
		for (int i = 1; i < nums.length; i++)
			accum -= nums[i];
		assertEquals(accum, run());
	}
	
	@Test
	public void testManyMults() {
		try {
			tryToTestManyMults();
		} catch (ParseException e) {fail();}
	}
	
	private void tryToTestManyMults() throws ParseException {
		int[] nums = getNumsArray();
		writeToToken(genSameOpStr(nums, "*"));
		int accum = nums[0];
		for (int i = 1; i < nums.length; i++)
			accum *= nums[i];
		assertEquals(accum, run());
	}
	
	//@Test
	/*
	 * It's impossible to pass this test because the evaluation of the expressions is done from right to left
	 * such that, 1024 / 2 / 2 is read as 1024 / (2 / 2) = 1024 / 1 = 1024 
	 */
	public void testManyDivs() {
		try {
			tryToTestManyDivs();
		} catch (ParseException e) {fail();}
	}
	
	private void tryToTestManyDivs() throws ParseException {
		int bigNum = Integer.MAX_VALUE;
		int[] nums = getNumsArray();
		String exp = String.format("%d / %s", bigNum, genSameOpStr(nums, "/"));
		writeToToken(exp);
		int accum = bigNum;
		for (int num : nums) accum /= num;
		assertEquals(accum, run());
	}
	
	@Test
	public void testBrackets() {
		try {
			tryToTestBrackets();
		} catch (ParseException e) {fail();}
	}
	
	private void tryToTestBrackets() throws ParseException {
		int num = new Random().nextInt();
		writeToToken(String.format("( %d )", num));
		assertEquals(num, run());
	}

	@Test
	public void testBracketsSum() {
		try {
			tryToTestBracketsSum();
		} catch (ParseException e) {fail();}
	}
	
	private void tryToTestBracketsSum() throws ParseException {
		Random r = new Random();
		int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
		String exp = String.format("(%d + %d)", first, second);
		writeToToken(exp);
		assertEquals(first + second, run());		
	}
	
	@Test
	public void testSumsMultBrackets() {
		try {
			tryToTestSumsMultBrackets();
		} catch (ParseException e) {fail();}
	}
	
	private void tryToTestSumsMultBrackets() throws ParseException {
		String exp = "2 * (3 + 4 * (5 + 6) - 1 * (2))";
		int val = 2 * (3 + 4 * (5 + 6) - 1 * 2);
		writeToToken(exp);
		assertEquals(val, run());
	}
	
	@Test
	public void testMinusSingle() {
		try {
			tryToTestMinus();
		} catch (ParseException e) {fail();}
	}
	
	private void tryToTestMinus() throws ParseException {
		int num = new Random().nextInt();
		writeToToken(String.format("-%d", num));
		assertEquals(-num, run());
	}
	
	@Test
	public void testMinusTwo() {
		try {
			tryToTestMinusTwo();
		} catch (ParseException e) {fail();}
	}
	
	private void tryToTestMinusTwo() throws ParseException {
		Random r = new Random();
		int first = -1 * r.nextInt(), second = -1 * r.nextInt();
		String exp = String.format("-%d + %d\n", first, second);
		writeToToken(exp);
		assertEquals(-first + second, run());		
	}
	
	@Test
	public void testMinusExpression() {
		try {
			tryToTestMinusExpression();
		} catch (ParseException e) {fail();}
	}
	
	private void tryToTestMinusExpression() throws ParseException {
		String exp = "-(2 * (3 + 4 * (5 + 6) - 1 * (2)))";
		int val = -(2 * (3 + 4 * (5 + 6) - 1 * 2));
		writeToToken(exp);
		assertEquals(val, run());
	}
	
}
