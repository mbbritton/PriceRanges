package britton;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import britton.beans.Company;
import britton.business.GatherCompanies;

public class GatherCompaniesTest {

	List<Company> testObject;
	
	@Before
	public void setUp() throws Exception {
		testObject = GatherCompanies.getInstance();
	}

	@Test
	//This test is meant to exercise if only one instance is created, we only want 1!
	public void testgetInstance_only_one_instance_of_company_list() {
		List<Company> result = GatherCompanies.getInstance();

		assertSame(testObject, result); 
	}

}
