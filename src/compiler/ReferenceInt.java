package compiler;

public class ReferenceInt {

    private static final String REF_INT_DEFAULT_NAME = "ref_int";

    private static int intRefCounter = 0;

    public final String name;

    public ReferenceInt(String refDircetory) {
        name = String.format("%s/%s_%d", refDircetory, REF_INT_DEFAULT_NAME, intRefCounter++);
    }

}
