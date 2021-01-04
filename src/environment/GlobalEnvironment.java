package environment;

import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import tree.Function;
import tree.Variable;

import java.util.HashMap;
import java.util.Map;

import dataTypes.IValue;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Camponês - 50051
**/

public class GlobalEnvironment{
	
	private final Map<String, IValue> globalVars = new HashMap<>();
	
	private final Map<String, Function> globalFuncs = new HashMap<>();   

    public GlobalEnvironment(){
    	
    }

    public void assocVar(String id, IValue value) throws IDDeclaredTwiceException {
        
    	if (globalVars.containsKey(id))
            throw new IDDeclaredTwiceException(id);
    	globalVars.put(id, value);
    }
    
    public void assocFunc(String id, Function fun) throws IDDeclaredTwiceException {
        
    	if (globalFuncs.containsKey(id))
            throw new IDDeclaredTwiceException(id);
    	globalFuncs.put(id, fun);
    }

    public IValue findVar(String id) throws UndeclaredIdentifierException{
    	IValue val = globalVars.get(id);
        if (val != null)
            return val;
            
        throw new UndeclaredIdentifierException(id);
    }
    
    public Function findFunc(String id) throws UndeclaredIdentifierException{
        Function fun = globalFuncs.get(id);
        if (fun != null)
            return fun;
            
        throw new UndeclaredIdentifierException(id);
    }

}
