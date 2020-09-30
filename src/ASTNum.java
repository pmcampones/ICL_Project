public class ASTNum implements ASTNode {

int val;

        public int eval() { return val; }

        public ASTNum(int n)
        {
	   val = n;
        }

}

