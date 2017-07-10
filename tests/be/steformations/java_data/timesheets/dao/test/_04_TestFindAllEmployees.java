package be.steformations.java_data.timesheets.dao.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.java_data.timesheets.entities.Employee;
import be.steformations.java_data.timesheets.service.TimesheetsDataService;

public class _04_TestFindAllEmployees extends TestsUtils {

	private TimesheetsDataService service;
	
	@Before
	public void setUp() throws Exception {
		service = TestsFactory.createTimesheetsDataService();
		assertNotNull(service);
	}

	@Test
	public void testFindAllEmployees() {
		java.util.List<? extends Employee> list = this.service.findAllEmployees();
		assertNotNull(list);
		assertEquals(3, list.size());
		for (Employee e : list) {
			assertNotNull(e);
			assertEquals(e, this.service.findOneEmployeeById(e.getId()));
		}
	}
}
