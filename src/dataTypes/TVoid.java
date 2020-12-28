package dataTypes;

public class TVoid implements IType{

    @Override
    public boolean equals(Object other) {
        return other instanceof TVoid;
    }

	@Override
	public String getCompString() {
		return null;
	}

}
