package tests.interpreter;

import static parser.Parser.Start;

import dataTypes.TypeErrorException;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.GenericTester;


public class InterpreterTester extends GenericTester {

    protected static String run()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        return Start().eval(new Environment<>()).toString();
    }
}