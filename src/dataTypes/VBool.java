package dataTypes;

public class VBool implements IValue{
	
	private final boolean val;
	
	public VBool(boolean val) {
		this.val = val;
	}
	
	@Override
	public String toString() {
		return String.valueOf(val);
	}
	
	public boolean isTrue() {
		return val;
	}

}
