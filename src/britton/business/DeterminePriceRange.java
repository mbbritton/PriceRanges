package britton.business;

import java.util.ArrayList;
import java.util.List;

import britton.beans.Company;
import britton.beans.Customer;

public class DeterminePriceRange {

	/* This function does the work to find out whether a company is a match for a 
	 * customer that is passed in OR that a customer is a match for a company.
	 * I made the conscious decision to pull out the cuLow, cuHigh,
	 * coLow, and coHigh to make the doesCustomerFallInCompanyRange and doesCompanyFallInCustomerRange
	 * methods more readable.  
	*/
	public List<Company> findCompaniesWithinPriceRange(Customer cus) {
		//This will be the return value populated with the list of companies available for shopping within the budget
		List<Company> placesToShop = new ArrayList<>();
		
		//This returns the list of companies available for shopping
		List<Company> companyList = GatherCompanies.getInstance();
		
		//Will need to find these in each company
		int comLow, comHigh;
		
		//Only need to get the customer's info one time
		int cusHigh = cus.getHighRange();
		int cusLow = cus.getLowRange();
		
		for(Company com : companyList){
			//Need to find these per company
			comLow = com.getLowPrice();
			comHigh = com.getHighPrice();
			
			//Check to see if customer fits the company or if company fits the customer
			if(doesCustomerFallInCompanyRange(cusLow, cusHigh, comLow, comHigh) || doesCompanyFallInCustomerRange(cusLow, cusHigh, comLow, comHigh)){
				  placesToShop.add(com);
			}	
		}
		return placesToShop;
	}
		//This method serves to return whether a customer falls into a company's price range
		private boolean doesCustomerFallInCompanyRange(int cusLow, int cusHigh, int comLow, int comHigh) {
			return cusLow >= comLow && cusLow <= comHigh || cusHigh >= comLow && cusHigh <= comHigh;
		}
		
		//This method serves to return whether a company falls within a customer's price range
		private boolean doesCompanyFallInCustomerRange(int cusLow, int cusHigh, int comLow, int comHigh){
			return comLow >= cusLow && comLow <= cusHigh || comHigh >= cusHigh && comHigh <= cusHigh;
		}
		



}
