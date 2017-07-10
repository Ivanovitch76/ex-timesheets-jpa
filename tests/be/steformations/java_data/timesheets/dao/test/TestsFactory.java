package be.steformations.java_data.timesheets.dao.test;

import be.steformations.java_data.timesheets.service.TimesheetsDataService;



public class TestsFactory {
	
	public static TimesheetsDataService createTimesheetsDataService() {
		
		String persistenceUnit = "postgresql_eclipselink";
		javax.persistence.EntityManager em 
		 	= javax.persistence.Persistence.createEntityManagerFactory("postgresql_eclipselink")
		 		.createEntityManager();
		return new be.steformations.pc.timesheets.jpa.TimesheetsJpaDataServiceImpl(em);
	}
}
