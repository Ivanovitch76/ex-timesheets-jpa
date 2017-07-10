package be.steformations.pc.timesheets.dao.entities;

import java.io.Serializable;
import java.util.Date;

import be.steformations.java_data.timesheets.entities.Employee;
import be.steformations.java_data.timesheets.entities.Prestation;
import be.steformations.java_data.timesheets.entities.Project;

public class PrestationImpl implements Serializable, Prestation{

	private static final long serialVersionUID = 4801158593778079407L;

	protected Long id;
	protected Date day;
	protected Employee employee;
	protected Project project;
	protected int duration;
	protected String comment;
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Prestation#getId()
	 */
	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Prestation#getDay()
	 */
	@Override
	public Date getDay() {
		return day;
	}
	
	public void setDay(Date day) {
		this.day = day;
	}
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Prestation#getEmployee()
	 */
	@Override
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Prestation#getProject()
	 */
	@Override
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Prestation#getDuration()
	 */
	@Override
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/* (non-Javadoc)
	 * @see be.steformations.pc.ejb.timesheets.dao.entities.Prestation#getComment()
	 */
	@Override
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + duration;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
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
		PrestationImpl other = (PrestationImpl) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (duration != other.duration)
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prestation [id=" + id + ", day=" + day + ", employee=" + employee + ", project=" + project
				+ ", duration=" + duration + "]";
	}
}
