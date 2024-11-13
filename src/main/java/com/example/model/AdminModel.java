package com.example.model;

public class AdminModel {
	private String username;
	private String adminpwd;
	private String role;
	public AdminModel() {
		
	}
	public AdminModel(String un,String pwd,String role) {
			this.username=un;
			this.adminpwd=pwd;
			this.role=role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAdminpwd() {
		return adminpwd;
	}
	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
