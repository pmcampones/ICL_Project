package dataTypes;

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
