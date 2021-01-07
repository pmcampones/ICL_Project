import environment.Environment;
import parser.Parser;
import tree.ASTNode;

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
