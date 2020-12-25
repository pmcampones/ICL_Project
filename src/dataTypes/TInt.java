package dataTypes;

public class TInt implements IType {

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof TInt;
    }
}
