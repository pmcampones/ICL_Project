package tests;

import java.io.IOException;
import java.util.Random;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;

import static tests.GenericTester.MAX_RAND;
import static tests.GenericTester.writeToToken;

public interface StaticTypecheckerOpTester {
	
	@Test
	void testSimpleIntExp()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestSimpleIntExp() {
		int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x: int = %d in x end", num);
        writeToToken(exp);
        return String.valueOf(num);
	}
	
	@Test
	void testSimpleBoolExp()
			throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestSimpleBoolExp() {
		writeToToken("def x: bool = true in x end");
		return "true";
	}
	
	@Test
	void testSimpleRefExp()
			throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;

	static String getExpectedTestSimpleRefExp() {
		int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x: ref int = new %d in !x end", num);
        writeToToken(exp);
        return String.valueOf(num);
	}
	
	@Test
	void testSeveralExp()
			throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestSeveralExp() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x: int = %d y: bool = true z: ref int = new %d in x + !z end", n1, n2);
        writeToToken(exp);
        return String.valueOf(n1 + n2);
	}
	
	@Test
	void testChainedTypes()
			throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestChainedTypes() {
		int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x: ref int = new %d y: ref ref ref int = new new x in !!!y end", num);
        writeToToken(exp);
        return String.valueOf(num);
	}
	
	@Test
	void testStaticAndDynamic()
			throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestStaticAndDynamic() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d y: int = %d in x + y end", n1, n2);
        writeToToken(exp);
        return String.valueOf(n1 + n2);
	}
	
	@Test
	void testDifferentScopesStatic()
			throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestDifferentScopesStatic() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x: int = %d in def x: ref int = new (x + %d) in !x end end", n1, n2);
        writeToToken(exp);
        return String.valueOf(n1 + n2);
	}
	
	@Test
	void testDifferentScopesStaticAndDynamic()
			throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestDifferentScopesStaticAndDynamic() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x: int = %d in def x = new (x + %d) in !x end end", n1, n2);
        writeToToken(exp);
        return String.valueOf(n1 + n2);
	}
	
}
