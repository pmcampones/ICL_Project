package environment;

public class VariableNotDefinedException extends RuntimeException {

    private static final String VARIABLE_NOT_DEFINED_DEFAULT_MESSAGE =
            "The variable %s is not defined in any scope.";

    public VariableNotDefinedException (String id) {
        super(String.format(VARIABLE_NOT_DEFINED_DEFAULT_MESSAGE, id));
    }
}
