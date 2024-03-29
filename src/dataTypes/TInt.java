package dataTypes;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class TInt implements IType {

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof TInt;
    }

	@Override
	public String getCompString() {
		return "I";
	}
}
