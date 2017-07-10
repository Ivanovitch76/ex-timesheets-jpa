package be.steformations.java_data.timesheets.dao.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.java_data.timesheets.entities.Employee;
import be.steformations.java_data.timesheets.entities.Project;
import be.steformations.java_data.timesheets.service.TimesheetsDataService;

public class _03_TestFindOneEmployeeByLoginAndPassword extends TestsUtils {

	private TimesheetsDataService service;
	
	@Before
	public void setUp() throws Exception {
		service = TestsFactory.createTimesheetsDataService();
		assertNotNull(service);
	}

	@Test
	public void testFindBatmanByLoginAndPassword() {
		Employee e = this.service.findOneEmployeeByLoginAndPassword("batman", "I am Batman");
		this.isBatman(e);
		
		java.util.List<? extends Project> list = e.getManagedProjects();
		assertNotNull(list);
		assertEquals(1, list.size());
		this.isJusticeLeague(list.get(0));
	}
	
	@Test
	public void testFindWonderwomanByLoginAndPassword() {
		Employee e = service.findOneEmployeeByLoginAndPassword("wonder", "woman");
		this.isWonderwoman(e);
		
		java.util.List<? extends Project> list = e.getManagedProjects();
		assertNotNull(list);
		assertEquals(0, list.size());
	}

}
