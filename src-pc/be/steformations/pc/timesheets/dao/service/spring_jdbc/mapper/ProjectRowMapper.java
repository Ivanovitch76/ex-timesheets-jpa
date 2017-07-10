package be.steformations.pc.timesheets.dao.service.spring_jdbc.mapper;

import be.steformations.pc.timesheets.dao.entities.EmployeeImpl;
import be.steformations.pc.timesheets.dao.entities.ProjectImpl;

public class ProjectRowMapper implements org.springframework.jdbc.core.RowMapper<ProjectImpl>{

	@Override
	public ProjectImpl mapRow(java.sql.ResultSet rs, int rank) throws java.sql.SQLException {
		EmployeeImpl employee = new EmployeeImpl();
		
		employee.setId(new Long(rs.getInt("employeeId")));
		employee.setFirstname(rs.getString("employeeFirstname"));
		employee.setName(rs.getString("employeeName"));
		employee.setLogin(rs.getString("employeeLogin"));
		employee.setPassword(rs.getString("employeePassword"));
		
		ProjectImpl project = new ProjectImpl();
		
		project.setId(new Long(rs.getInt("projectId")));
		project.setDescription(rs.getString("projectDescription"));
		project.setName(rs.getString("projectName"));
		project.setStartDate(rs.getDate("projectStartDate"));
		project.setEndDate(rs.getDate("projectEndDate"));
		project.setManager(employee);
		
		return project;
	}

}
