package be.steformations.pc.timesheets.dao.entities;

import be.steformations.java_data.timesheets.entities.Employee;

public class EmployeeImpl implements Employee, java.io.Serializable {

	private static final long serialVersionUID = 8479633087803385004L;

	protected Long id;
	protected String firstname;
	protected String name;
	protected String login;
	protected String password;
	protected java.util.List<ProjectImpl> managedProjects;
	protected java.util.List<PrestationImpl> prestations;
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Employee#getId()
	 */
	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Employee#getFirstname()
	 */
	@Override
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Employee#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Employee#getLogin()
	 */
	@Override
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Employee#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Employee#getManagedProjects()
	 */
	@Override
	public java.util.List<ProjectImpl> getManagedProjects() {
		if (managedProjects == null) {
			managedProjects = new java.util.ArrayList<ProjectImpl>();
		}
		return managedProjects;
	}
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Employee#getPrestations()
	 */
	@Override
	public java.util.List<PrestationImpl> getPrestations() {
		if(prestations == null) {
			prestations = new java.util.ArrayList<PrestationImpl>();
		}
		return prestations;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeImpl other = (EmployeeImpl) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", name=" + name + ", login=" + login + ", password="
				+ password + "]";
	}
	
}
