package be.steformations.pc.timesheets.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import be.steformations.java_data.timesheets.entities.Employee;
import be.steformations.java_data.timesheets.entities.Prestation;
import be.steformations.java_data.timesheets.entities.Project;
import be.steformations.java_data.timesheets.service.TimesheetsDataService;
import be.steformations.pc.timesheets.dao.entities.EmployeeImpl;
import be.steformations.pc.timesheets.dao.entities.PrestationImpl;
import be.steformations.pc.timesheets.dao.entities.ProjectImpl;

public class TimesheetsJpaDataServiceImpl implements TimesheetsDataService{

	private javax.persistence.EntityManager entityManager;	
	
	
	
	public TimesheetsJpaDataServiceImpl(javax.persistence.EntityManager entityManager) {
		super();
		this.entityManager = entityManager;

	}

	@Override
	public List<? extends Employee> findAllEmployees() {
		java.util.List<EmployeeImpl> list = null;
		String jpql = "select t from Timesheet t";
		javax.persistence.TypedQuery<EmployeeImpl> query
			= this.entityManager.createQuery(jpql, EmployeeImpl.class);
		list = query.getResultList();
		
		return list;
	}

	@Override
	public Employee findOneEmployeeById(long id) {
		Employee employee = null;
		//uniquement les recherches sur l'Id de l'entité
		employee = this.entityManager.find(EmployeeImpl.class, id);
		
		return employee;
	}

	@Override
	public Employee findOneEmployeeByFirstnameAndName(String firstname, String name) {
		EmployeeImpl employee = null;
		
		String jpql = "select t from Timesheet t where lower(t.firstname) = lower(?1) and upper(t.name) = upper(?2)";
		javax.persistence.TypedQuery<EmployeeImpl> query
			= this.entityManager.createQuery(jpql, EmployeeImpl.class);
		query.setParameter(1, firstname);
		query.setParameter(2, name);
		
		try{
			employee = query.getSingleResult(); // recherche d'une seule instance
		} catch(javax.persistence.NoResultException e){
			// pas de correspondance dans la db
		}
		
		return employee;
	}

	@Override
	public Employee findOneEmployeeByLoginAndPassword(String login, String password) {
		EmployeeImpl employee = null;
		
		String jpql = "select t from Timesheet t where t.login = ?1 and t.password = ?2";
		javax.persistence.TypedQuery<EmployeeImpl> query
			= this.entityManager.createQuery(jpql, EmployeeImpl.class);
		query.setParameter(1, login);
		query.setParameter(2, password);
		
		try{
			employee = query.getSingleResult(); // recherche d'une seule instance
		} catch(javax.persistence.NoResultException e){
			// pas de correspondance dans la db
		}
		
		return employee;
	}

	@Override
	public List<? extends Project> findAllProjects() {
		java.util.List<ProjectImpl> list = null;
		String jpql = "select p from ProjectImpl p";
		javax.persistence.TypedQuery<ProjectImpl> query
			= this.entityManager.createQuery(jpql, ProjectImpl.class);
//		query.setParameter(1, nom);
		list = query.getResultList();
		
		return list;
	}
 
	@Override
	public Project findOneProjectById(long id) {
		Project project = null;
		//uniquement les recherches sur l'Id de l'entité
		project = this.entityManager.find(ProjectImpl.class, id);
		
		return project;
	}

	@Override
	public Project findOneProjectByName(String name) {
		ProjectImpl project = null;
		
		javax.persistence.TypedQuery<ProjectImpl> query
			= this.entityManager.createNamedQuery("FindOneProjectByName", ProjectImpl.class);
		query.setParameter(1, name);
		
		try{
			project = query.getSingleResult();
		} catch(javax.persistence.NoResultException e){
			
		}
		
		return project;
	}

	@Override
	public PrestationImpl findOnePrestationById(long id) {
		PrestationImpl prestation = null;
		//uniquement les recherches sur l'Id de l'entité
		try {
			prestation = this.entityManager.find(PrestationImpl.class, id);
		} catch(org.springframework.dao.EmptyResultDataAccessException ignored) {}	
		
		
		return prestation;
	}

	@Override
	public List<? extends Prestation> findAllPrestationsByEmployeeId(long id) {
//		java.util.List<PrestationImpl> list = null;
//		String jpql = "select pr from PrestationImpl pr where pr.employee.id = ?1";
//		javax.persistence.TypedQuery<PrestationImpl> query
//			= this.entityManager.createQuery(jpql, PrestationImpl.class);
//		query.setParameter(1, id);
//		list = query.getResultList();
//		
//		return list;		
		
		List<PrestationImpl> list = null;
		
		javax.persistence.TypedQuery<PrestationImpl> query
			= this.entityManager.createNamedQuery("FindAllPrestationsByEmployeeId", PrestationImpl.class);
		query.setParameter(1, id);
		
		try{
			list = query.getResultList();
		} catch(javax.persistence.NoResultException e){
			
		}
		
		return list;

	}

	@Override
	public List<? extends Prestation> findAllPrestationsByProjectId(long id) {
		java.util.List<PrestationImpl> list = null;
		String jpql = "select pr from PrestationImpl pr where pr.project.id = ?1";
		javax.persistence.TypedQuery<PrestationImpl> query
			= this.entityManager.createQuery(jpql, PrestationImpl.class);
		query.setParameter(1, id);
		list = query.getResultList();
		
		return list;
	}

	@Override
	public Prestation addPrestation(long employeeId, long projectId, String comment, Date day, int duration) {
		PrestationImpl pr = null;
		if (day != null && duration >= 0 && this.findOneEmployeeById(employeeId) != null 
				&& this.findOneProjectById(projectId) != null && comment != null) {
				pr = new PrestationImpl();
				pr.setEmployee((EmployeeImpl)this.findOneEmployeeById(employeeId));
				pr.setProject((ProjectImpl)this.findOneProjectById(projectId));
				pr.setComment(comment);
				pr.setDay(day);
				pr.setDuration(duration);

				this.entityManager.getTransaction().begin();
				this.entityManager.persist(pr);
				this.entityManager.getTransaction().commit();
			}
		
		return pr;	

	}

	@Override
	public PrestationImpl deletePrestation(long id) {
		PrestationImpl p = this.findOnePrestationById(id);
		if (p != null){
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(p);
			this.entityManager.getTransaction().commit();
		}
		return p;
	}

}
