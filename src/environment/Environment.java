package environment;

import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;

import java.util.HashMap;
import java.util.Map;

public class Environment {

    private final Environment parentEnv;
    
    private final int depth;

    private final Map<String, Integer> scopeVars = new HashMap<>();

    public Environment(){
    	parentEnv = null;
    	depth = -1;
    }

    private Environment(Environment parentEnv) {
        this.parentEnv = parentEnv;
        depth = parentEnv.depth + 1;
    }

    public Environment beginScope() {
        return new Environment(this);
    }

    public Environment endScope() {
        return parentEnv;
    }

    public void assoc(String id, Integer val) throws IDDeclaredTwiceException {
        if (scopeVars.containsKey(id))
            throw new IDDeclaredTwiceException(id);
        scopeVars.put(id, val);
    }

    public Integer find(String id) throws UndeclaredIdentifierException{
        Integer val = scopeVars.get(id);
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
