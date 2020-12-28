package dataTypes;

public class TBool implements IType {

    @Override
    public String toString() {
        return "bool";
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof TBool;
    }

	@Override
	public String getCompString() {
		return "I";
	}

}
