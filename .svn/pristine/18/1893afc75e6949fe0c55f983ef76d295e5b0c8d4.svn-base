package be.steformations.pc.timesheets.dao.entities;

import java.io.Serializable;
import java.util.Date;

import be.steformations.java_data.timesheets.entities.Employee;
import be.steformations.java_data.timesheets.entities.Project;

public class ProjectImpl implements Serializable, Project{

	private static final long serialVersionUID = -192305227492264968L;

	protected Long id;
	protected String name;
	protected String description;
	protected Date startDate;
	protected Date endDate;
	protected Employee manager;
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Project#getId()
	 */
	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Project#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Project#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Project#getStartDate()
	 */
	@Override
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Project#getEndDate()
	 */
	@Override
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Project#getManager()
	 */
	@Override
	public Employee getManager() {
		return manager;
	}
	
	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", manager=" + manager + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		ProjectImpl other = (ProjectImpl) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
}
