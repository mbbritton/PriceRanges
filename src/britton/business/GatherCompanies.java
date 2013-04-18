package britton.business;

import java.util.ArrayList;
import java.util.List;

import britton.beans.Company;

public class GatherCompanies {
	
	private static List<Company> companyListINSTANCE;
	
	//Only want to build/initialize this list once then reuse it in the future (singleton)
	public static List<Company> getInstance(){
		//Check if it is null or empty, if so we need to build it for the first time
		if(null == companyListINSTANCE || companyListINSTANCE.size() == 0){
			companyListINSTANCE = populateCompanies();
		}
		return companyListINSTANCE;
	}
	
	private static List<Company> populateCompanies(){
		 companyListINSTANCE = new ArrayList<Company>();
		 
		//Create companies and add to list
	    companyListINSTANCE.add(createCompany("A", 1000, 3000));
	    companyListINSTANCE.add(createCompany("B", 6000, 10000));
	    companyListINSTANCE.add(createCompany("C", 500, 2500));
		
		return companyListINSTANCE;
	}
	
	//A helper method to create a company (extracted mainly for readability)
	private static Company createCompany(String name, int lowPrice, int highPrice){
		Company company = new Company(name, lowPrice, highPrice);
		return company;
	}
}
