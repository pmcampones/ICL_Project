package environment.exceptions;

public class IDDeclaredTwiceException extends Exception {

    private static final String ID_DECLARED_TWICE_DEFAULT_MESSAGE =
            "The chosen ID %s has already been declared in this scope.";

    public IDDeclaredTwiceException(String id) {
        super(String.format(ID_DECLARED_TWICE_DEFAULT_MESSAGE, id));
    }
}
