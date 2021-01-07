package dataTypes;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class VVoid implements IValue{

    @Override
    public String toString() {
        return "";
    }

    @Override
    public IType getType() {
        return new TVoid();
    }
}
