package tests.interpreter;

import static parser.Parser.Start;

import dataTypes.TypeErrorException;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.NotEnoughArgumentsException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.GenericTester;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class InterpreterTester extends GenericTester {

    protected static String run()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        return Start().eval(new Environment<>()).toString();
    }
}
