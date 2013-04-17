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

}
