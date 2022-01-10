package com.example.ppm.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.ppm.service.RoleService;

public class MyUserDetails implements UserDetails {

	
	private User user;
	
	private Allocation allocation;
	
	public MyUserDetails(User user) {
		super();
		this.user = user;
	}
	
	  public MyUserDetails(Allocation allocation) {
		super();
		this.allocation = allocation;
	}

	@Override public Collection<? extends GrantedAuthority> getAuthorities() {
	  Set<Role> roles = user.getRoles();
			  List<SimpleGrantedAuthority> authorities =
	  new ArrayList<>(); for(Role role:roles) { authorities.add(new
	  SimpleGrantedAuthority(role.getRoletype())); } return authorities; }
	 

	
	public boolean hasRole(String roleName) {
        return this.user.hasRole(roleName);
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getFirstname()
	{
		return user.getFirstname();
	}

	public String getLastname()
	{
		return user.getLastname();
	}
	public String getPhone()
	{
		return user.getPhone();
	}
	public String getAddress()
	{
		return user.getAddress();
	}
	public String getRolename()
	{
		return user.getRolename();
	}
	
	/*
	 * public Set<Allocation> getAllocation() { return user.getAllocation(); }
	 */
}
