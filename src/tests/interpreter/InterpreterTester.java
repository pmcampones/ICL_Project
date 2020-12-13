package tests.interpreter;

import dataTypes.IValue;
import dataTypes.TypeErrorException;
import dataTypes.VInt;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.GenericTester;

import static parser.Parser.Start;


public class InterpreterTester extends GenericTester {

    protected static String run()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        return Start().eval(new Environment<>()).toString();
    }
}
