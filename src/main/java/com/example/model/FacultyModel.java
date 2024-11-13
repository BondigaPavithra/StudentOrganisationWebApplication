package com.example.model;

public class FacultyModel {
	private int fId;
	private String fname;
	private String lname;
	private String username;
	private String password;
	private long mobile;
	private String gender;
	private String address;
	private int cid;
	private int year_of_exp;
	private String courseName;
	private String status;
	public FacultyModel() {
			
	}
	public FacultyModel(int fid,String fname,String lname,String username,String pwd,
			long mobile,String gender,String address,int cid,int exp,String cname,String st) {
		this.fId=fid;
		this.fname=fname;
		this.lname=lname;
		this.username=username;
		this.password=pwd;
		this.mobile=mobile;
		this.gender=gender;
		this.address=address;
		this.cid=cid;
		this.year_of_exp=exp;
		this.courseName=cname;
		this.status=st;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String toString() {
		return "faculty model";
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
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
	public void setPassword(String pwd) {
		this.password = pwd;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getYear_of_exp() {
		return year_of_exp;
	}
	public void setYear_of_exp(int year_of_exp) {
		this.year_of_exp = year_of_exp;
	}
	
	
}
