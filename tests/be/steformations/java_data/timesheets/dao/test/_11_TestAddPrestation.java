package be.steformations.java_data.timesheets.dao.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.java_data.timesheets.entities.Prestation;
import be.steformations.java_data.timesheets.service.TimesheetsDataService;

public class _11_TestAddPrestation extends TestsUtils {

	private TimesheetsDataService service;
	
	@Before
	public void setUp() throws Exception {
		service = TestsFactory.createTimesheetsDataService();
		assertNotNull(service);
	}

	@Test
	public void testAddPrestation() {
		long time = System.currentTimeMillis();
		long employeeId = 3L;
		long projectId = 2L;
		java.util.Date day = this.getStringAsDate("2017-06-30");
		String comment = String.valueOf(time);
		int duration = 3;
		
		Prestation p = this.service.addPrestation(employeeId, projectId, comment, day, duration);
		assertNotNull(p);
		assertNotNull(p.getId());
		assertEquals(day, p.getDay());
		assertEquals(comment, p.getComment());
		assertEquals(duration, p.getDuration());
		this.isSuperman(p.getEmployee());
		this.isFortressOfSolitude(p.getProject());
		
		Prestation p2 = this.service.findOnePrestationById(p.getId());
		assertNotNull(p2);
		assertEquals(p, p2);
	}
}
