package environment;

import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

import java.util.HashMap;
import java.util.Map;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class Environment<V> {

    private final Environment<V> parentEnv;
    
    private final int depth;

    private final Map<String, V> scopeVars = new HashMap<>();

    public Environment(){
    	parentEnv = null;
    	depth = -1;
    }

    private Environment(Environment<V> parentEnv) {
        this.parentEnv = parentEnv;
        depth = parentEnv.depth + 1;
    }

    public Environment<V> beginScope() {
        return new Environment<>(this);
    }

    public Environment<V> endScope() {
        return parentEnv;
    }

    public void assoc(String id, V val) throws IDDeclaredTwiceException {
        if (scopeVars.containsKey(id))
            throw new IDDeclaredTwiceException(id);
        scopeVars.put(id, val);
    }

    public V find(String id) throws UndeclaredIdentifierException{
        V val = scopeVars.get(id);
        if (val != null)
            return val;
        if (parentEnv == null)
            throw new UndeclaredIdentifierException(id);
        return parentEnv.find(id);
    }
    
    public int getDepth() {
    	return depth;
    }

}
