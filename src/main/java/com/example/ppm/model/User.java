package com.example.ppm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "FirstName")
	@NotBlank(message="Firstname cannot be Empty!!")
	private String firstname;
	@Column(name = "LastName")
	private String lastname;
	@Column(name = "UserName", nullable = false, unique = true)
	@NotBlank(message="Username cannot be Empty!!")
	@Size(min=3,max=15,message="Username must be between 3-15 characters!!")
	private String username;
	@Column(name = "Password", nullable = false)
	@NotBlank(message="Password cannot be Empty!!")
	private String password;
	@Column(name = "Contact")
	private String phone;
	@Column(name = "Address")
	private String address;
	  public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}


	@Column(name = "RoleName", nullable = false, unique = true) 
	  private String rolename;
	 
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set <Allocation> allocation= new HashSet<>();

	public Set<Allocation> getAllocation() {
		return allocation;
	}
	public void setAllocation(Set<Allocation> allocation) {
		this.allocation = allocation;
	}

	
	
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

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)

	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "USER_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") })
	private Set<Role> roles = new HashSet<>();

	public boolean hasRole(String roleName) {
		Iterator<Role> iterator = this.roles.iterator();
		while (iterator.hasNext()) {
			Role role = iterator.next();
			if (role.getRoletype().equals(roleName)) {
				return true;
			}
		}

		return false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User() {
		super();
	}

	public User(Long id, String firstname, String lastname, String username, String password, String phone,
			String address, Set<Role> roles) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.roles = roles;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public User(User user) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "EmployeeId=" +id+ ", Firstname=" +firstname + ", Lastname=" +lastname + ", Username=" +username + ", Password=" +password
				+ ", Phone=" +phone + ", Address=" +address + ",Address=" +rolename + ", Roles=" +roles +  "";
	}

}
