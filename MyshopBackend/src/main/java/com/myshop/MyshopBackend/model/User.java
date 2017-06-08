package com.myshop.MyshopBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User 
{
	@Id
	String username,password,custname,roleuser,roleadmin,email,addr;
	int mobileno;
	
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

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
		
	}

	public String getRoleuser() {
		return roleuser;
	}

	public void setRoleuser(String roleuser) {
		this.roleuser = roleuser;
		
	}
	public String getRoleadmin() {
		return roleadmin;
	}

	public void setRoleadmin(String roleadmin) {
		this.roleadmin = roleadmin;
		
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		
	}
	public int getMobileno() {
		return mobileno;
	}

	public void setMobileNo(int mobileno) {
		this.mobileno = mobileno;
		
	}
	public String getAddr() {
		return addr;
	}

	public void setaddr(String addr) {
		this.addr = addr;
		
	}
}
