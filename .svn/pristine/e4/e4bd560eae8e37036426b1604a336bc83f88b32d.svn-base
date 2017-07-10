package be.steformations.java_data.timesheets.dao.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.java_data.timesheets.entities.Project;
import be.steformations.java_data.timesheets.service.TimesheetsDataService;

public class _05_TestFindOneProjectById extends TestsUtils {

	private TimesheetsDataService service;
	
	@Before
	public void setUp() throws Exception {
		service = TestsFactory.createTimesheetsDataService();
		assertNotNull(service);
	}

	@Test
	public void testFindJusticeLeagueById() {
		Project p = this.service.findOneProjectById(1L);
		this.isJusticeLeague(p);
	}
}
