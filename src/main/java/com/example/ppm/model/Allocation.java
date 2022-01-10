package com.example.ppm.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name="Allocations")
public class Allocation {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long proid;
	private Long empid;
	
	private String employeename;
	private String projectname;
	private String lastname;
	private String email;
	
	

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	@OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	 @JoinColumn(name = "fk_projectid")
	 private Project project;
	
	@OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	 @JoinColumn(name = "fk_employeeid")
	 private User user;
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getProid() {
		return proid;
	}

	public void setProid(Long proid) {
		this.proid = proid;
	}

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString()
	{
		return "EmployeeId=" +empid+ ", ProjectId=" +proid + ", Employeename=" +employeename + ", Projectname=" +projectname + 
				", Lastname=" +lastname + ", email=" +email +"";
		}

	
}
