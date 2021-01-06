package tests;

import static tests.GenericTester.MAX_RAND;
import static tests.GenericTester.writeToToken;

import java.io.IOException;
import java.util.Random;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.*;
import parser.ParseException;

public interface GlobalVarsTester {
	
	static int generateGlobalVar() {
		Random r = new Random();
        int val = r.nextInt(MAX_RAND);
        String exp = String.format("def globv:int = %d;;", val);
        writeToToken(exp);
		return val;
		
	}
	
    @Test
    void testGlobalVar()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalVar(int val) {
        String exp = "globv;;";
        writeToToken(exp);
    	return String.valueOf(val);
    }
    
    @Test
    void testGlobalVarSum()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalVarSum(int val) {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("%d + %d + globv", first, second, val);
        writeToToken(exp);
        return String.valueOf(first + second + val);
  }
    
    @Test
    void testGlobalVarDiv()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalVarDiv(int val) {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND);
        String exp = String.format("%d / globv", first);
        writeToToken(exp);
        return String.valueOf(first / val);
  }
    
    @Test
    void testGlobalVarDef()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalVarDef(int val) {
        Random r = new Random();
        int[] nums = new int[5];
        for(int i = 0; i < nums.length; i++)
            nums[i] = r.nextInt(MAX_RAND);
        String exp = String.format("def x = 1 in %d * (-%d + %d * (%d - %d)) + globv end",
                nums[0], nums[1], nums[2], nums[3], nums[4]);
        writeToToken(exp);
        return String.valueOf(nums[0] * (-nums[1] + nums[2] * (nums[3] - nums[4])) + val);
  }
    
    @Test
    void testGlobalVarIf()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalVarIf(int val) {
		
    	Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        int thenV = r.nextInt(MAX_RAND), elseV = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new (%d < %d) y = new 2 in if !x then y := %d else y := %d + globv end; !y + 1 end",
                n1, n2, thenV, elseV);
        writeToToken(exp);
        int res = n1 < n2 ? thenV + 1 : elseV + 1 + val;
        return String.valueOf(res);
  }
    
    @Test
    void testGlobalVarNew()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalVarNew(int val) {
		Random r = new Random();
        int x = r.nextInt(MAX_RAND), y = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x + !new %d + globv end", x, y);
        writeToToken(exp);
        return String.valueOf(x + y + val);
  }
    
    @Test
    void testGlobalVarWhile()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalVarWhile(int val) {
		int limit = new Random().nextInt(MAX_RAND);
        String exp = String.format(
                "def i = new 0 sum = new 0 in " +
                    "while !i < (%d + globv) do " +
                        "i := !i + 1; " +
                        "sum := !sum + !i " +
                    "end; " +
                    "!sum " +
                "end", limit);
        writeToToken(exp);
        return String.valueOf(computeGaussianSum(limit + val));
  }
    
	private static int computeGaussianSum(int limit) {
        int sum = 0;
        for (int i = 0; i <= limit; i++)
            sum += i;
        return sum;
    }
    
    @Test
    void testGlobalVarSemi()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalVarSemi(int val) {
		Random r = new Random();
		int x1 = r.nextInt(MAX_RAND), x2 = r.nextInt(MAX_RAND);
		int num = r.nextInt(MAX_RAND);
		String exp = String.format("def x = new %d in x := (!x + %d); !x + %d + globv end",
				x1, x2, num);
		writeToToken(exp);
		return String.valueOf(x1 + x2 + num + val);
  }

}
