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
	
}
