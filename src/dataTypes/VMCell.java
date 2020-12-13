package dataTypes;

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
	
}
