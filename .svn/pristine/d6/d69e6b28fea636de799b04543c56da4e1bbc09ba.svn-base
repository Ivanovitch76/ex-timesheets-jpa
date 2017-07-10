package be.steformations.java_data.timesheets.dao.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.java_data.timesheets.entities.Employee;
import be.steformations.java_data.timesheets.entities.Project;
import be.steformations.java_data.timesheets.service.TimesheetsDataService;

public class _01_TestFindOneEmployeeById extends TestsUtils {

	private TimesheetsDataService service;
	
	@Before
	public void setUp() throws Exception {
		service = TestsFactory.createTimesheetsDataService();
		assertNotNull(service);
	}

	@Test
	public void testFindBatmanById() {
		Employee e = this.service.findOneEmployeeById(1L);
		this.isBatman(e);
		
		java.util.List<? extends Project> list = e.getManagedProjects();
		assertNotNull(list);
		assertEquals(1, list.size());
		this.isJusticeLeague(list.get(0));
	}
	
	@Test
	public void testFindWonderwomanById() {
		Employee e = service.findOneEmployeeById(2L);
		this.isWonderwoman(e);
		
		java.util.List<? extends Project> list = e.getManagedProjects();
		assertNotNull(list);
		assertEquals(0, list.size());
	}

}
