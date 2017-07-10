package be.steformations.java_data.timesheets.dao.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.java_data.timesheets.entities.Prestation;
import be.steformations.java_data.timesheets.service.TimesheetsDataService;

public class _08_TestFindOnePrestationById extends TestsUtils {

	private TimesheetsDataService service;
	
	@Before
	public void setUp() throws Exception {
		service = TestsFactory.createTimesheetsDataService();
		assertNotNull(service);
	}

	@Test
	public void testFindSendmailById() {
		Prestation p = this.service.findOnePrestationById(1L);
		this.isSendmail(p);
	}
	
	@Test
	public void testFindReadmailById() {
		Prestation p = this.service.findOnePrestationById(2L);
		this.isReadmail(p);
	}

}
