package be.steformations.java_data.timesheets.entities;

public interface Employee {

	Long getId();

	String getFirstname();

	String getName();

	String getLogin();

	String getPassword();

	java.util.List<? extends Project> getManagedProjects();

	java.util.List<? extends Prestation> getPrestations();

}