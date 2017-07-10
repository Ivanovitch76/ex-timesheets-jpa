package be.steformations.pc.timesheets.dao.service.spring_jdbc.mapper;

import be.steformations.pc.timesheets.dao.entities.EmployeeImpl;
import be.steformations.pc.timesheets.dao.entities.ProjectImpl;

public class EmployeeResultsetExtractor implements org.springframework.jdbc.core.ResultSetExtractor<EmployeeImpl>{

	@Override
	public EmployeeImpl extractData(java.sql.ResultSet rs) throws java.sql.SQLException, org.springframework.dao.DataAccessException {
		EmployeeImpl employee = null;
		java.util.Set<Integer> projectIdsSet = new java.util.HashSet<>();
		
		while (rs.next()) {
			if (employee == null) {
				employee = new EmployeeImpl();
				employee.setId(rs.getLong("employeeId"));
				employee.setFirstname(rs.getString("employeeFirstname"));
				employee.setName(rs.getString("employeeName"));
				employee.setLogin(rs.getString("employeeLogin"));
				employee.setPassword(rs.getString("employeePassword"));
			}
			
			int projectId = rs.getInt("projectId");
			if (! rs.wasNull() && !projectIdsSet.contains(projectId)) {
				ProjectImpl project = new ProjectImpl();
				project.setId(new Long(projectId));
				project.setName(rs.getString("projectName"));
				project.setDescription(rs.getString("projectDescription"));
				project.setStartDate(rs.getDate("projectStartDate"));
				project.setEndDate(rs.getDate("projectEndDate"));
				project.setManager(employee);
				employee.getManagedProjects().add(project);
				projectIdsSet.add(projectId);
			}
		}
		
		return employee;
	}

}
