package tests.compiler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.DefVarsTester.getExpectedTestDefDifferentVarsSameScope;
import static tests.DefVarsTester.getExpectedTestDefNestedCaires1;
import static tests.DefVarsTester.getExpectedTestDefNestedCaires2;
import static tests.DefVarsTester.getExpectedTestDefNestedSimple;
import static tests.DefVarsTester.getExpectedTestDefSameVarDifferentScopesComplex;
import static tests.DefVarsTester.getExpectedTestDefSameVarDifferentScopesSimple;
import static tests.DefVarsTester.getExpectedTestDefUsingComplex;
import static tests.DefVarsTester.getExpectedTestDefUsingSimple;
import static tests.DefVarsTester.getExpectedTestDefWithoutUsingComplex;
import static tests.DefVarsTester.getExpectedTestDefWithoutUsingSimple;
import static tests.DefVarsTester.getExpectedTestTwoFramesSameScope;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.DefVarsTester;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

class DefVarsCompilerTest extends CompilationTester implements DefVarsTester {

	@Override
    @Test
    public void testDefWithoutUsingSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException, TypeErrorException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestDefWithoutUsingSimple(), compileAndGetResults(methodName, 1));
    }

	@Override
    @Test
    public void testDefWithoutUsingComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException, TypeErrorException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestDefWithoutUsingComplex(), compileAndGetResults(methodName, 1));
    }

	@Override
    @Test
    public void testDefUsingSimple() 
    		throws ParseException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, IOException,
    		InterruptedException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestDefUsingSimple(), compileAndGetResults(methodName, 1));
    }

	@Override
    @Test
    public void testDefUsingComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestDefUsingComplex(), compileAndGetResults(methodName, 1));
    }

	@Override
    @Test
    public void testDefNestedSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestDefNestedSimple(), compileAndGetResults(methodName, 2));
    }

	@Override
    @Test
    public void testDefNestedCaires1()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestDefNestedCaires1(), compileAndGetResults(methodName, 2));
    }

	@Override
    @Test
    public void testDefNestedCaires2()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestDefNestedCaires2(), compileAndGetResults(methodName, 3));
    }

	@Override
    @Test
    public void testDefSameVarDifferentScopesSimple()
            throws ParseException, IDDeclaredTwiceException, 
            UndeclaredIdentifierException, IOException,
            InterruptedException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestDefSameVarDifferentScopesSimple(), compileAndGetResults(methodName, 2));
    }

	@Override
    @Test
    public void testDefSameVarDifferentScopesComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestDefSameVarDifferentScopesComplex(), compileAndGetResults(methodName, 3));
    }

	@Override
    @Test
    public void testDefDifferentVarsSameScope()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException, TypeErrorException {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(getExpectedTestDefDifferentVarsSameScope(), compileAndGetResults(methodName, 3));
    }
    
    @Test
    public void testSameAsTheProjectAssignment()
    		throws ParseException, IOException, 
    		InterruptedException, TypeErrorException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException {
    	String exp = "def x = 2 y = 3 in def k = x+y in x+y+k end end";
    	writeToToken(exp);
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    	assertEquals("10", compileAndGetResults(methodName, 2));
    }
    
    @Override
    @Test
    public void testTwoFramesSameScope() 
    		throws ParseException, IOException, 
    		InterruptedException, TypeErrorException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException {
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    	assertEquals(getExpectedTestTwoFramesSameScope(), compileAndGetResults(methodName, 3));
    }
}
