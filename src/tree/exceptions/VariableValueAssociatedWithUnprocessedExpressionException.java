package tree.exceptions;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Camponês - 50051
**/

public class VariableValueAssociatedWithUnprocessedExpressionException extends RuntimeException {

    private static final String VARIABLE_VALUE_ASSOCIATED_WITH_UNPROCESSED_EXPRESSION_DEFAULT_MESSAGE =
            "Cannot associate the value of variable %s in this environment because its corresponding "
                    + "expression is yet to be evaluated";
    public VariableValueAssociatedWithUnprocessedExpressionException(String id) {
        super(String.format(VARIABLE_VALUE_ASSOCIATED_WITH_UNPROCESSED_EXPRESSION_DEFAULT_MESSAGE, id));
    }
}
