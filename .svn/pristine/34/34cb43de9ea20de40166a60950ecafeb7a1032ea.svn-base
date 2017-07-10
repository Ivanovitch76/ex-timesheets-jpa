package be.steformations.pc.timesheets.dao.service.jpa;

import be.steformations.java_data.timesheets.entities.Employee;
import be.steformations.java_data.timesheets.entities.Prestation;
import be.steformations.java_data.timesheets.entities.Project;
import be.steformations.java_data.timesheets.service.TimesheetsDataService;
import be.steformations.pc.timesheets.dao.entities.EmployeeImpl;
import be.steformations.pc.timesheets.dao.entities.PrestationImpl;
import be.steformations.pc.timesheets.dao.entities.ProjectImpl;

public class TimesheetsJpaDataServiceImpl implements TimesheetsDataService {

	protected javax.persistence.EntityManager entityManager;
	
	public TimesheetsJpaDataServiceImpl(javax.persistence.EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public Employee findOneEmployeeById(long id) {
		return entityManager.find(EmployeeImpl.class, id);
	}

	@Override
	public java.util.List<EmployeeImpl> findAllEmployees() {
		javax.persistence.TypedQuery<EmployeeImpl> query = entityManager.createNamedQuery("findAllEmployees", EmployeeImpl.class);
		return query.getResultList();
	}
	
	@Override
	public Employee findOneEmployeeByFirstnameAndName(String firstname,
			String name) {
		Employee employee = null;
		javax.persistence.TypedQuery<EmployeeImpl> query = entityManager.createNamedQuery("findOneEmployeeByFirstnameAndName", EmployeeImpl.class);
		query.setParameter(1, firstname);
		query.setParameter(2, name);
		try {
			employee = query.getSingleResult();
		} catch(javax.persistence.NoResultException e) {}
		return employee;
	}

	@Override
	public Employee findOneEmployeeByLoginAndPassword(String login,
			String password) {
		Employee employee = null;
		javax.persistence.TypedQuery<EmployeeImpl> query = entityManager.createNamedQuery("findOneEmployeeByLoginAndPassword", EmployeeImpl.class);
		query.setParameter(1, login);
		query.setParameter(2, password);
		try {
			employee = query.getSingleResult();
		} catch(javax.persistence.NoResultException e) {}
		return employee;
	}

	@Override
	public java.util.List<ProjectImpl> findAllProjects() {
		javax.persistence.TypedQuery<ProjectImpl> query = entityManager.createNamedQuery("findAllProjects", ProjectImpl.class);
		return query.getResultList();
	}
	
	@Override
	public Project findOneProjectById(long id) {
		return entityManager.find(ProjectImpl.class, id);
	}

	@Override
	public Project findOneProjectByName(String name) {
		Project project = null;
		javax.persistence.TypedQuery<ProjectImpl> query = entityManager.createNamedQuery("findOneProjectByName", ProjectImpl.class);
		query.setParameter(1, name);
		try {
			project = query.getSingleResult();
		} catch(javax.persistence.NoResultException e) {}
		return project;
	}

	@Override
	public Prestation findOnePrestationById(long id) {
		return entityManager.find(PrestationImpl.class, id);
	}

	@Override
	public java.util.List<PrestationImpl> findAllPrestationsByEmployeeId(long id) {
		javax.persistence.TypedQuery<PrestationImpl> query = entityManager.createNamedQuery("findAllPrestationByEmployeeId", PrestationImpl.class);
		query.setParameter(1, id);
		return query.getResultList();
	}

	@Override
	public java.util.List<PrestationImpl> findAllPrestationsByProjectId(long id) {
		javax.persistence.TypedQuery<PrestationImpl> query = entityManager.createNamedQuery("findAllPrestationsByProjectId", PrestationImpl.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	
	@Override
	public Prestation addPrestation(long employeeId, long projectId,
			String comment, java.util.Date day, int duration) {
		PrestationImpl prestation = null;
		Employee employee = findOneEmployeeById(employeeId);
		Project project = findOneProjectById(projectId);
		if ( project != null && employee != null ) {
			prestation = new PrestationImpl();
			prestation.setComment(comment);
			prestation.setDay(day);
			prestation.setDuration(duration);
			prestation.setEmployee(employee);
			prestation.setProject(project);
			
			if (!entityManager.isJoinedToTransaction()) {
				entityManager.getTransaction().begin();
				entityManager.persist(prestation);
				entityManager.getTransaction().commit();
			} else {
				entityManager.persist(prestation);
			}
		}
		return prestation;
	}

	@Override
	public Prestation deletePrestation(long id) {
		Prestation prestation = findOnePrestationById(id);
		if (prestation != null) {
			if (!entityManager.isJoinedToTransaction()) {
				entityManager.getTransaction().begin();
				entityManager.remove(prestation);
				entityManager.getTransaction().commit();
			} else {
				entityManager.remove(prestation);
			}
			entityManager.getEntityManagerFactory().getCache()
				.evict(EmployeeImpl.class, prestation.getEmployee().getId());
		}
		return prestation;
	}

}
