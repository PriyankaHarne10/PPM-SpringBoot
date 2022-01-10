package com.example.ppm.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="RoleType",nullable=false,unique = true)
	private String roletype;
	
	/*
	 * @Column(name ="RoleName",nullable=false,unique = true) private String
	 * rolename;
	 */
	
	/*
	 * @Temporal(TemporalType.DATE)
	 * 
	 * @Column(nullable=false) private Date created_at;
	 * 
	 * public Date getCreated_at() { return created_at; } public void
	 * setCreated_at(Date created_at) { this.created_at = created_at; }
	 * 
	 * @PrePersist private void onCreate() { created_at = new Date(); }
	 */
	 
	@Override
	public String toString()
	{
		return this.roletype;
	}
	
	
	
	@ManyToMany(mappedBy =  "roles")
	private List<User> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role() {
		super();
	}

	public Role(Long id) {
		super();
		this.id = id;
	}

	public Role(Long roleid, String roletype, List<User> users) {
		super();
		this.id = roleid;
		this.roletype = roletype;
		this.users = users;
	}

	public Long getRoleid() {
		return id;
	}

	public void setRoleid(Long roleid) {
		this.id = roleid;
	}

	/*
	 * public String getRolename() { return rolename; }
	 * 
	 * public void setRolename(String rolename) { this.rolename = rolename; }
	 */
	public String getRoletype() {
		return roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
