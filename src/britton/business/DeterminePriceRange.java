package britton.business;

import java.util.ArrayList;
import java.util.List;

import britton.beans.Company;
import britton.beans.Customer;

public class DeterminePriceRange {

	public List<Company> findCompaniesWithinPriceRange(Customer cu) {
		List<Company> placesToShop = new ArrayList<>();
		int coLow, coHigh;
		
		List<Company> companyList = new ArrayList<>();
		companyList.add(new Company("A", 1000, 3000));
		companyList.add(new Company("B", 6000, 10000));
		companyList.add(new Company("C", 500, 2500));
		
		int cuHigh = cu.getHighRange();
		int cuLow = cu.getLowRange();
		
		for(Company co : companyList){
			coLow = co.getLowPrice();
			coHigh = co.getHighPrice();
			
			if(doesCustomerFallInCompanyRange(cuLow, cuHigh, coLow, coHigh) || doesCompanyFallInCustomerRange(cuLow, cuHigh, coLow, coHigh)){
				  placesToShop.add(co);
			}	
		}
		return placesToShop;
	}
		//This method serves to return whether a customer falls into a company's price range
		private boolean doesCustomerFallInCompanyRange(int cuLow, int cuHigh, int coLow, int coHigh) {
			return cuLow >= coLow && cuLow <= coHigh || cuHigh >= coLow && cuHigh <= coHigh;
		}
		
		//This method serves to return whether a company falls within a customer's price range
		private boolean doesCompanyFallInCustomerRange(int cuLow, int cuHigh, int coLow, int coHigh){
			return coLow >= cuLow && coLow <= cuHigh || coHigh >= cuHigh && coHigh <= cuHigh;
		}
		



}
