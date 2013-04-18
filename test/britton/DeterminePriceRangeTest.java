package britton;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import britton.beans.Company;
import britton.beans.Customer;
import britton.business.DeterminePriceRange;

public class DeterminePriceRangeTest {

	public DeterminePriceRange testObject;
	
	@Before
	public void setUp() throws Exception {
		testObject = new DeterminePriceRange();
	}

	@Test
	public void testFindCompaniesWithinPriceRange_happy_path() {
		//Assemble
		Customer customer = new Customer(2500, 5000);
		
		//Act
		List<Company> result = testObject.findCompaniesWithinPriceRange(customer);
		
		//Assert
		assertEquals(2, result.size());
		assertEquals("A", result.get(0).getCompanyName());
		assertEquals("C", result.get(1).getCompanyName());
	}
	
	@Test
	public void testFindCompaniesWithinPriceRange_on_edges_of_ranges() {
		//Assemble
		Customer customer = new Customer(3000,  6000);
		
		//Act
		List<Company> result = testObject.findCompaniesWithinPriceRange(customer);
		
		//Assert
		assertEquals(2, result.size());
		assertEquals("A", result.get(0).getCompanyName());
		assertEquals("B", result.get(1).getCompanyName());
	}
	
	@Test
	public void testFindCompaniesWithinPriceRange_no_matches(){
		//Assemble
		Customer customer = new Customer(4000, 5000);
		
		//Act
		List<Company> result = testObject.findCompaniesWithinPriceRange(customer);
		
		//Assert
		assertEquals(0, result.size());
	}
	
	@Test
	public void testFindCompaniesWithinPriceRange_zero_to_large_range(){
		//Assemble
		Customer customer = new Customer(0, 15000);
		
		//Act
		List<Company> result = testObject.findCompaniesWithinPriceRange(customer);
		
		//Assert
		assertEquals(3, result.size());
		assertEquals("A", result.get(0).getCompanyName());
		assertEquals("B", result.get(1).getCompanyName());
		assertEquals("C", result.get(2).getCompanyName());	
	}
	
	@Test
	public void testfindCompanies_with_values_passed_in_backwards() {
		//Assemble
		//Customer swapped their low-high for high-low, that's ok, we'll still help them!
		Customer customer = new Customer(1500, 700);
		
		//Act
		List<Company> result = testObject.findCompaniesWithinPriceRange(customer);
		
		//Assert
		assertEquals(2, result.size());
		assertEquals("A", result.get(0).getCompanyName());
		assertEquals("C", result.get(1).getCompanyName());
	}
	
	@Test
	public void testfindCompanies_with_identical_values_no_company_matches() {
		//Assemble
		Customer customer = new Customer(5000, 5000);
		
		//Act
		List<Company> result = testObject.findCompaniesWithinPriceRange(customer);
		
		//Assert
		assertEquals(0, result.size());
	}
	
	@Test
	public void testfindCompanies_with_identical_values_with_company_matches() {
		//Assemble
		Customer customer = new Customer(6000, 6000);
		
		//Act
		List<Company> result = testObject.findCompaniesWithinPriceRange(customer);
		
		//Assert
		assertEquals(1, result.size());
		assertEquals("B", result.get(0).getCompanyName());

	}
	
	@Test
	public void testfindCompanies_testing_min_and_max() {
		//Assemble
		Customer customer = new Customer(0, Integer.MAX_VALUE);
		
		//Act
		List<Company> result = testObject.findCompaniesWithinPriceRange(customer);
		
		//Assert
		assertEquals(3, result.size());
		assertEquals("A", result.get(0).getCompanyName());
		assertEquals("B", result.get(1).getCompanyName());
		assertEquals("C", result.get(2).getCompanyName());
	}
	
	@Test
	public void testfindCompanies_with_no_customer_range_defined_defualts_to_be_used() {
		//Assemble
		Customer customer = new Customer();
		
		//Act
		List<Company> result = testObject.findCompaniesWithinPriceRange(customer);
		
		//Assert
		assertEquals(3, result.size());
		assertEquals("A", result.get(0).getCompanyName());
		assertEquals("B", result.get(1).getCompanyName());
		assertEquals("C", result.get(2).getCompanyName());
	}
	
	@Test
	public void testfindCompanies_with_one_value_given() {
		//Assemble
		Customer customer = new Customer(1500);
		
		//Act
		List<Company> result = testObject.findCompaniesWithinPriceRange(customer);
		
		//Assert
		assertEquals(2, result.size());
		assertEquals("A", result.get(0).getCompanyName());
		assertEquals("C", result.get(1).getCompanyName());
	}
	
	


}
