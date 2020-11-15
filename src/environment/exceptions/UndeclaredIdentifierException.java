package environment.exceptions;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Camponês - 50051
**/

public class UndeclaredIdentifierException extends Exception {

    private static final String VARIABLE_NOT_DEFINED_DEFAULT_MESSAGE =
            "The variable %s is not defined in any scope.";

    public UndeclaredIdentifierException (String id) {
        super(String.format(VARIABLE_NOT_DEFINED_DEFAULT_MESSAGE, id));
    }
}
