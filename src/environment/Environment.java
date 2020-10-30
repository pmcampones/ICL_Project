package environment;

import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

import java.util.HashMap;
import java.util.Map;

public class Environment {

    private final Environment parentEnv;

    private final Map<String, Integer> scopeVars = new HashMap<>();

    public Environment() {
        this(null);
    }

    public Environment(Environment parentEnv) {
        this.parentEnv = parentEnv;
    }

    public Environment beginScope() {
        return new Environment(parentEnv);
    }

    public Environment endScope() {
        return parentEnv;
    }

    public void assoc(String id, int val) throws IDDeclaredTwiceException {
        if (scopeVars.containsKey(id))
            throw new IDDeclaredTwiceException(id);
        scopeVars.put(id, val);
    }

    public int find(String id) throws UndeclaredIdentifierException{
        Integer val = scopeVars.get(id);
        if (val != null)
            return val;
        if (parentEnv == null)
            throw new UndeclaredIdentifierException(id);
        return parentEnv.find(id);
    }

}
