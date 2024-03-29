package dataTypes;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class VMCell implements IValue{
	
	private IValue currVal;

	public VMCell(IValue initialValue) {
		currVal = initialValue;
	}
	
	public void setValue(IValue updatedValue) {
		currVal = updatedValue;
	}
	
	public IValue getValue() {
		return currVal;
	}
	
	@Override
	public String toString() {
		return currVal.toString();
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof VMCell)
			return this.currVal == ((VMCell)other).currVal;
		return false;
	}

	public boolean deepEquals(Object other) {
		if (other instanceof VMCell)
			return this.currVal.equals(((VMCell)other).currVal);
		return false;
	}

	@Override
	public IType getType() {
		return new TMCell(currVal.getType());
	}
}
