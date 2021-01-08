package tests;

import static tests.GenericTester.MAX_RAND;
import static tests.GenericTester.writeToToken;

import java.io.IOException;
import java.util.Random;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.*;
import parser.ParseException;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public interface GlobalFuncsTester {
	
	static int generateValue() {
		Random r = new Random();
        int val = r.nextInt(MAX_RAND);
		return val;
	}
	
	static void generateGlobalFunc() {
        String exp = "def foo(n:int):int = n + n end;;";
        writeToToken(exp);
	}
	
    @Test
    void testGlobalFunc()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalFunc(int val) {
        String exp = String.format("foo(%d);;;", val);
        writeToToken(exp);
    	return String.valueOf(val+val);
    }
    
    @Test
    void testGlobalFuncSum()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalFuncSum(int val) {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("%d + %d + foo(%d)", first, second, val);
        writeToToken(exp);
        return String.valueOf(first + second + (val + val));
  }
    
    @Test
    void testGlobalFuncDiv()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalFuncDiv(int val) {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("%d / %d + foo(%d)", first, second, val);
        writeToToken(exp);
        return String.valueOf(first / second + (val + val));
  }
    
    @Test
    void testGlobalFuncDef()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalFuncDef(int val) {
        Random r = new Random();
        int[] nums = new int[5];
        for(int i = 0; i < nums.length; i++)
            nums[i] = r.nextInt(MAX_RAND);
        String exp = String.format("def x = 1 in %d * (-%d + %d * (%d - %d)) + foo(%d) end",
                nums[0], nums[1], nums[2], nums[3], nums[4], val);
        writeToToken(exp);
        return String.valueOf(nums[0] * (-nums[1] + nums[2] * (nums[3] - nums[4])) + (val + val));
  }
    
    @Test
    void testGlobalFuncIf()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalFuncIf(int val) {
		
    	Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        int thenV = r.nextInt(MAX_RAND), elseV = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new (%d < %d) y = new 2 in if !x then y := %d else y := %d + foo(%d) end; !y + 1 end",
                n1, n2, thenV, elseV, val);
        writeToToken(exp);
        int res = n1 < n2 ? thenV + 1 : elseV + 1 + (val + val);
        return String.valueOf(res);
  }
    
    @Test
    void testGlobalFuncNew()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalFuncNew(int val) {
		Random r = new Random();
        int x = r.nextInt(MAX_RAND), y = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x + !new %d + foo(%d) end", x, y, val);
        writeToToken(exp);
        return String.valueOf(x + y + (val + val));
  }
    
    @Test
    void testGlobalFuncWhile()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalFuncWhile(int val) {
		int limit = new Random().nextInt(MAX_RAND);
        String exp = String.format(
                "def i = new 0 sum = new 0 in " +
                    "while !i < (%d + foo(%d)) do " +
                        "i := !i + 1; " +
                        "sum := !sum + !i " +
                    "end; " +
                    "!sum " +
                "end", limit, val);
        writeToToken(exp);
        return String.valueOf(computeGaussianSum(limit + (val + val)));
  }
    
	private static int computeGaussianSum(int limit) {
        int sum = 0;
        for (int i = 0; i <= limit; i++)
            sum += i;
        return sum;
    }
    
    @Test
    void testGlobalFuncSemi()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalFuncSemi(int val) {
		Random r = new Random();
		int x1 = r.nextInt(MAX_RAND), x2 = r.nextInt(MAX_RAND);
		int num = r.nextInt(MAX_RAND);
		String exp = String.format("def x = new %d in x := (!x + %d); !x + %d + foo(%d) end",
				x1, x2, num, val);
		writeToToken(exp);
		return String.valueOf(x1 + x2 + num + (val + val));
  }

}
