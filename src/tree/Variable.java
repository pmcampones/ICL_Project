package tree;

import java.util.Optional;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class Variable {
    public final String id;
    public final Optional<String> type;
    public final ASTNode exp;

    public Variable(String id, String type, ASTNode exp) {
        this.id = id;
        this.type = Optional.ofNullable(type);
        this.exp = exp;
    }
}
