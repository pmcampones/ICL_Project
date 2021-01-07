package compiler;

public class ReferenceGeneric {

    private static final String REF_GENERIC_DEFAULT_NAME = "ref_ref";

    private static int refRefCounter = 0;

    public final String name;

    public ReferenceGeneric(String refDirectory) {
        name = String.format("%s/%s_%d", refDirectory, REF_GENERIC_DEFAULT_NAME, refRefCounter++);
    }
}
