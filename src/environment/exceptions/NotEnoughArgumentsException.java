package environment.exceptions;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Camponês - 50051
**/

public class NotEnoughArgumentsException extends Exception {

    private static final String ID_DECLARED_TWICE_DEFAULT_MESSAGE =
            "The number of arguments provided (%d) does not match the function %s (%d).";

    public NotEnoughArgumentsException(int provided, String id, int needed) {
        super(String.format(ID_DECLARED_TWICE_DEFAULT_MESSAGE, provided, id, needed));
    }
}
