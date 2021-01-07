package dataTypes;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

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
