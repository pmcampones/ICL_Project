package dataTypes;

public class VInt implements IValue{
	
	private final int val;
	
	public VInt(int val) {
		this.val = val;
	}
	
	@Override
	public String toString() {
		return String.valueOf(val);
	}
	
	public int getVal() {
		return val;
	}

}
