package be.steformations.pc.timesheets.dao.service.spring_jdbc;

import be.steformations.java_data.timesheets.entities.Employee;
import be.steformations.java_data.timesheets.service.TimesheetsDataService;
import be.steformations.pc.timesheets.dao.entities.EmployeeImpl;
import be.steformations.pc.timesheets.dao.entities.PrestationImpl;
import be.steformations.pc.timesheets.dao.entities.ProjectImpl;
import be.steformations.pc.timesheets.dao.service.spring_jdbc.mapper.EmployeeResultsetExtractor;
import be.steformations.pc.timesheets.dao.service.spring_jdbc.mapper.PrestationRowMapper;
import be.steformations.pc.timesheets.dao.service.spring_jdbc.mapper.ProjectRowMapper;

public class TimesheetsSpringJdbcDataServiceImpl implements TimesheetsDataService {

	protected final String EMPLOYEE_QUERY_BASE 
		= "select e.id as employeeId, e.firstname as employeeFirstname, e.name as employeeName, e.login as employeeLogin, e.password as employeePassword, "
		+ "       p.id as projectId, p.name as projectName, p.description as projectDescription, p.startdate as projectStartDate, p.endDate as projectEndDate "
		+ "from employee as e left join project as p on p.manager = e.id ";
	
	protected final String PROJECT_QUERY_BASE
		= "select p.id as projectId, p.name as projectName, p.description as projectDescription, p.startdate as projectStartDate, p.enddate as projectEndDate, "
		+ "       e.id as employeeId, e.firstname as employeeFirstname, e.name as employeeName, e.login as employeeLogin, e.password as employeePassword "
		+ "from project as p join employee as e on p.manager = e.id";
	
	protected final String PRESTATION_QUERY_BASE
		= "select pr.id as prestationId, pr.day as prestationDate, pr.duration as prestationDuration, pr.comment as prestationComment, "
		+ "		e.id as employeeId, e.firstname as employeeFirstname, e.name as employeeName, e.login as employeeLogin, e.password as employeePassword, "
		+ "     p.id as projectId, p.name as projectName, p.description as projectDescription, p.startdate as projectStartDate, p.endDate as projectEndDate, "
		+ "		m.id as managerId, m.firstname as managerFirstname, m.name as managerName, m.login as managerLogin, m.password as managerPassword "
		+ "from prestation as pr join employee as e on pr.employee = e.id join project as p on pr.project = p.id join employee as m on p.manager = m.id";
	
	protected final String PRESTATION_INSERT = "insert into prestation(day, employee, project, duration, comment) values(?, ?, ?, ?, ?)";
	
	protected final String PRESTATION_DELETE = "delete from prestation where id = ?";
	
	protected org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
	protected EmployeeResultsetExtractor employeeResultsetExtractor;
	protected ProjectRowMapper projectRowMapper;
	protected PrestationRowMapper prestationRowMapper;

	public TimesheetsSpringJdbcDataServiceImpl(org.springframework.jdbc.core.JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
		this.employeeResultsetExtractor = new EmployeeResultsetExtractor();
		this.projectRowMapper = new ProjectRowMapper();
		this.prestationRowMapper = new PrestationRowMapper();
	}
	
	@Override
	public java.util.List<? extends Employee> findAllEmployees() {
		java.util.List<EmployeeImpl> list = new java.util.ArrayList<>();
		String sql = "select id from employee";
		for (Integer id : this.jdbcTemplate.queryForList(sql, Integer.class)) {
			list.add(this.findOneEmployeeById(id));
		}
		return list;
	}

	@Override
	public EmployeeImpl findOneEmployeeById(long id) {
		String sql = String.format("%s %s", EMPLOYEE_QUERY_BASE, " where e.id = ?");
		EmployeeImpl employee = this.jdbcTemplate.query(sql, this.employeeResultsetExtractor, id);
		return employee;
	}

	@Override
	public EmployeeImpl findOneEmployeeByFirstnameAndName(String firstname, String name) {
		String sql = String.format("%s %s", EMPLOYEE_QUERY_BASE, " where lower(e.firstname) = lower(?) and lower(e.name) = lower(?)");
		EmployeeImpl employee = this.jdbcTemplate.query(sql, this.employeeResultsetExtractor, firstname, name);
		return employee;
	}

	@Override
	public EmployeeImpl findOneEmployeeByLoginAndPassword(String login, String password) {
		String sql = String.format("%s %s", EMPLOYEE_QUERY_BASE, " where e.login = ? and e.password = ?");
		EmployeeImpl employee = this.jdbcTemplate.query(sql, this.employeeResultsetExtractor, login, password);
		return employee;
	}

	@Override
	public java.util.List<ProjectImpl> findAllProjects() {
		java.util.List<ProjectImpl> list = this.jdbcTemplate.query(PROJECT_QUERY_BASE, this.projectRowMapper);
		return list;
	}

	@Override
	public ProjectImpl findOneProjectById(long id) {
		ProjectImpl project = null;
		String sql = String.format("%s %s", PROJECT_QUERY_BASE, "where p.id = ?");
		try {
			project = this.jdbcTemplate.queryForObject(sql, this.projectRowMapper, id);
		} catch(org.springframework.dao.EmptyResultDataAccessException ignored) {}
		return project;
	}

	@Override
	public ProjectImpl findOneProjectByName(String name) {
		ProjectImpl project = null;
		String sql = String.format("%s %s", PROJECT_QUERY_BASE, "where p.name = ?");
		try {
			project = this.jdbcTemplate.queryForObject(sql, this.projectRowMapper, name);
		} catch(org.springframework.dao.EmptyResultDataAccessException ignored) {}
		return project;
	}

	@Override
	public PrestationImpl findOnePrestationById(long id) {
		PrestationImpl prestation = null;
		String sql = String.format("%s %s", PRESTATION_QUERY_BASE, "where pr.id = ?");
		try {
			prestation = this.jdbcTemplate.queryForObject(sql, this.prestationRowMapper, id);
		} catch(org.springframework.dao.EmptyResultDataAccessException ignored) {}	
		return prestation;
	}

	@Override
	public java.util.List<PrestationImpl> findAllPrestationsByEmployeeId(long id) {
		String sql = String.format("%s %s", PRESTATION_QUERY_BASE, "where e.id = ?");
		return this.jdbcTemplate.query(sql, this.prestationRowMapper, id);
	}

	@Override
	public java.util.List<PrestationImpl> findAllPrestationsByProjectId(long id) {
		String sql = String.format("%s %s", PRESTATION_QUERY_BASE, "where p.id = ?");
		return this.jdbcTemplate.query(sql, this.prestationRowMapper, id);
	}

	@Override
	public PrestationImpl addPrestation(long employeeId, long projectId, String comment, java.util.Date day, int duration) {
		PrestationImpl prestation = null;
		
		if (day != null && duration >= 0 && this.findOneEmployeeById(employeeId) != null 
				&& this.findOneProjectById(projectId) != null) {
			this.jdbcTemplate.update(PRESTATION_INSERT, day, employeeId, projectId, duration, comment);
			Long id = this.jdbcTemplate.queryForObject("select max(id) from prestation", Long.class);
			prestation = this.findOnePrestationById(id);
		}
		
		return prestation;
	}

	@Override
	public PrestationImpl deletePrestation(long id) {
		PrestationImpl prestation = this.findOnePrestationById(id);
		if (prestation != null) {
			this.jdbcTemplate.update(PRESTATION_DELETE, id);
		}
		return prestation;
	}

}
