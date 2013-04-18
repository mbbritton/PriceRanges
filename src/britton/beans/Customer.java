package britton.beans;

public class Customer {
	
	//Default low in case a customer fails to provide a lower limit
	public static final int DEFAULT_LOW = 0;
	//Default high in case a customer fails to provide a higher limit
	public static final int DEFAULT_HIGH = Integer.MAX_VALUE;
	
	private int lowRange;
	private int highRange;	
	
	//Default constructor.  No ranges were provided so we assume they have unlimited funds, let's shop!
	public Customer() {
		this(DEFAULT_LOW, DEFAULT_HIGH);
	}	
	
	//Only given 1 parameter - we assume this is the highest amount they'll spend.
	public Customer(int value0) {
		this(DEFAULT_LOW, value0);
	}	
	
	//Both values provided, user wants to shop for items between value0 and value1.
	public Customer(int value0, int value1){
		this.lowRange = value0;
		this.highRange = value1;
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
