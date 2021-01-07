import environment.Environment;
import parser.Parser;
import tree.ASTNode;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class InterpreterMain {

	public static void main(String[] args) {
		new Parser(System.in);
	    while (true) {
	        try {
	            ASTNode exp = Parser.Start();
	            System.out.println( exp.eval(new Environment<>()) );
	        } catch (Exception e) {
	          System.out.println (e.getMessage());
	          Parser.ReInit(System.in);
	        }
	    }
	}
	
}
