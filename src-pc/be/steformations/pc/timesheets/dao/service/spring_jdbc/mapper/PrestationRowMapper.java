package be.steformations.pc.timesheets.dao.service.spring_jdbc.mapper;

import be.steformations.pc.timesheets.dao.entities.EmployeeImpl;
import be.steformations.pc.timesheets.dao.entities.PrestationImpl;
import be.steformations.pc.timesheets.dao.entities.ProjectImpl;

public class PrestationRowMapper implements org.springframework.jdbc.core.RowMapper<PrestationImpl> {

	@Override
	public PrestationImpl mapRow(java.sql.ResultSet rs, int rank) throws java.sql.SQLException {

		EmployeeImpl manager = new EmployeeImpl();
		
		manager.setId(new Long(rs.getInt("managerId")));
		manager.setFirstname(rs.getString("managerFirstname"));
		manager.setName(rs.getString("managerName"));
		manager.setLogin(rs.getString("managerLogin"));
		manager.setPassword(rs.getString("managerPassword"));
		
		ProjectImpl project = new ProjectImpl();
		
		project.setId(new Long(rs.getInt("projectId")));
		project.setDescription(rs.getString("projectDescription"));
		project.setName(rs.getString("projectName"));
		project.setStartDate(rs.getDate("projectStartDate"));
		project.setEndDate(rs.getDate("projectEndDate"));
		project.setManager(manager);
		
		EmployeeImpl employee = new EmployeeImpl();
		
		employee.setId(new Long(rs.getInt("employeeId")));
		employee.setFirstname(rs.getString("employeeFirstname"));
		employee.setName(rs.getString("employeeName"));
		employee.setLogin(rs.getString("employeeLogin"));
		employee.setPassword(rs.getString("employeePassword"));
		
		PrestationImpl prestation = new PrestationImpl();
		
		prestation.setId(new Long(rs.getInt("prestationId")));
		prestation.setComment(rs.getString("prestationComment"));
		prestation.setDuration(rs.getInt("prestationDuration"));
		prestation.setDay(rs.getDate("prestationDate"));
		prestation.setEmployee(employee);
		prestation.setProject(project);
		
		return prestation;
	}

}
