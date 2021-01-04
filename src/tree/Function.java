package tree;

import java.util.Collection;
import java.util.Optional;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/

public class Function {
    public final String name;
    public final String type;
    Collection<Variable> args;
    ASTNode body;

    public Function(String name, String type, Collection<Variable> args, ASTNode body) {
        this.name = name;
        this.type = type;
        this.args = args;
        this.body = body;
    }
}