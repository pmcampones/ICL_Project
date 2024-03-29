package dataTypes;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class TMCell implements IType {

    private final IType ref;

    public TMCell(IType ref) {
        this.ref = ref;
    }

    public IType getReferencedType() {
        return ref;
    }

    @Override
    public String toString() {
        return String.format("ref %s", ref.toString());
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof TMCell)
            return ((TMCell)other).ref.equals(ref);
        return false;
    }

	@Override
	public String getCompString() {
		return "Ljava/lang/Object;";
	}
	
	public String getRefFileName() {
		return ref instanceof TMCell ? "ref_class" : "ref_int";
	}
	
	public IType getRefType() {
		return ref;
	}

}
