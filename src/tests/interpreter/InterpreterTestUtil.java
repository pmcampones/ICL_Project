package tests.interpreter;

import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;

import static parser.Parser.Start;

public class InterpreterTestUtil {

    static int run()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        return Start().eval(new Environment());
    }
    
}
