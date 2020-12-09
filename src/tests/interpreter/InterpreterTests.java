package tests.interpreter;

import dataTypes.IValue;
import dataTypes.TypeErrorException;
import dataTypes.VInt;
import environment.Environment;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import org.junit.jupiter.api.TestInstance;
import parser.ParseException;
import parser.Parser;

import java.io.ByteArrayInputStream;

import static parser.Parser.Start;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InterpreterTests {

    public InterpreterTests() {
        new Parser(new ByteArrayInputStream(new byte[0]));
    }

    static int run()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        return ((VInt)Start().eval(new Environment<IValue>())).getVal();
    }

}
