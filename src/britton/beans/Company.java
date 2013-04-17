package britton.beans;

public class Company {
	
	private String companyName;
	private int lowPrice;
	private int highPrice;
	
	public Company(String name, int value0, int value1){
		this.companyName = name;
		this.lowPrice = value0;
		this.highPrice = value1;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(int lowPrice) {
		this.lowPrice = lowPrice;
	}

	public int getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(int highPrice) {
		this.highPrice = highPrice;
	}

}
