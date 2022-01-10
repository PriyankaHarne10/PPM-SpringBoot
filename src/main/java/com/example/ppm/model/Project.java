package com.example.ppm.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import javax.validation.constraints.NotBlank;





@Entity
@Table(name="Projects")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectid;
	
	@Column(name ="ProjectName")
	@NotBlank(message="Projectname cannot be Empty!!")
	private String projectname;
	

	private Date startdate;
	private Date enddate;
	
	
	
	
	 

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set <Allocation> allocation= new HashSet<>();

	public Set<Allocation> getAllocation() {
		return allocation;
	}

	public void setAllocation(Set<Allocation> allocation) {
		this.allocation = allocation;
	}
	
	public Long getProjectid() {
		return projectid;
	}

	public void setProjectid(Long projectid) {
		this.projectid = projectid;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	@Override
	public String toString()
	{
		return "ProjectId=" +projectid+ ", Projectname=" +projectname + ", StartDate=" +startdate + ", EndDate=" +enddate+ "";
	}
}
