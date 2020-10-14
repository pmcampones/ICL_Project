package tests;

import org.junit.jupiter.api.TestInstance;
import parser.Parser;

import java.io.ByteArrayInputStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DefVarsTest {

    public DefVarsTest() {
        new Parser(new ByteArrayInputStream(new byte[0]));
    }



}
