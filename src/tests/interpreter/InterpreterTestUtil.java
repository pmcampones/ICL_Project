package tests.interpreter;

import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;

import static parser.Parser.Start;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Camponês - 50051
**/

public class InterpreterTestUtil {

    static int run()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        return Start().eval(new Environment());
    }
    
}
