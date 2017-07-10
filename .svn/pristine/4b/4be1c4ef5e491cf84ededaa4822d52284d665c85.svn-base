package be.steformations.java_data.timesheets.service;

import be.steformations.java_data.timesheets.entities.Employee;
import be.steformations.java_data.timesheets.entities.Prestation;
import be.steformations.java_data.timesheets.entities.Project;

public interface TimesheetsDataService {

	java.util.List<? extends Employee> findAllEmployees();
	Employee findOneEmployeeById(long id);
	Employee findOneEmployeeByFirstnameAndName(String firstname, String name);
	Employee findOneEmployeeByLoginAndPassword(String login, String password);
	java.util.List<? extends Project> findAllProjects();
	Project findOneProjectById(long id);
	Project findOneProjectByName(String name);
	Prestation findOnePrestationById(long id);
	java.util.List<? extends Prestation> findAllPrestationsByEmployeeId(long id);
	java.util.List<? extends Prestation> findAllPrestationsByProjectId(long id);
	Prestation addPrestation(long employeeId, long projectId, String comment, 
			java.util.Date day, int duration);
	Prestation deletePrestation(long id);
}
