package britton.beans;

public class Customer {
	
	private int lowRange;
	private int highRange;	
	
	public Customer(int value0, int value1){
		this.lowRange = value0;
		this.highRange = value1;
	}
	
	public Customer(int value0) {
		// TODO Auto-generated constructor stub
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getLowRange() {
		return lowRange;
	}

	public void setLowRange(int lowRange) {
		this.lowRange = lowRange;
	}

	public int getHighRange() {
		return highRange;
	}

	public void setHighRange(int highRange) {
		this.highRange = highRange;
	}
}
