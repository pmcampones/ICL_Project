package tests.interpreter;

import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;

import static parser.Parser.Start;

import dataTypes.IValue;
import dataTypes.TypeErrorException;
import dataTypes.VInt;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

public class InterpreterTestUtil {

    static int run()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        return ((VInt)Start().eval(new Environment<IValue>())).getVal();
    }
    
}
