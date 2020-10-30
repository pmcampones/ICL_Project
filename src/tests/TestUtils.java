package tests;

import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import parser.Parser;

import java.io.ByteArrayInputStream;

import static parser.Parser.Start;

public class TestUtils {

    public static final int DEFAULT_LEN = 20;

    public static final int MAX_RAND = 100;

    public static void writeToToken(String exp) {
        exp += "\n";
        byte[] expBytes = exp.getBytes();
        Parser.ReInit(new ByteArrayInputStream(expBytes));
    }

    static int run()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        return Start().eval(new Environment());
    }
}
