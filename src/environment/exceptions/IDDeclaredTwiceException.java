package environment.exceptions;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class IDDeclaredTwiceException extends Exception {

    private static final String ID_DECLARED_TWICE_DEFAULT_MESSAGE =
            "The chosen ID %s has already been declared in this scope.";

    public IDDeclaredTwiceException(String id) {
        super(String.format(ID_DECLARED_TWICE_DEFAULT_MESSAGE, id));
    }
}
