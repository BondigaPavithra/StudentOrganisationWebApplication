package com.example.model;

public class StudentModel {
	private int sId;
	private String fname;
	private String lname;
	private String username;
	private String password;
	private long mobile;
	private String gender;
	private String address;
	private int cid;
	private String degree;
	private String specialization;
	private int passingYear;
	private String courseName;
	private String status;
	public StudentModel() {
		
	}
	public StudentModel(int sid,String fname,String lname,String username,String pwd,
			long mobile,String gender,String address,int cid,String degree,
			String specialization,int passingYear, String cname,String st) {
		this.sId=sid;
		this.fname=fname;
		this.lname=lname;
		this.username=username;
		this.password=pwd;
		this.mobile=mobile;
		this.gender=gender;
		this.address=address;
		this.cid=cid;
		this.degree=degree;
		this.specialization=specialization;
		this.passingYear=passingYear;
		this.courseName=cname;
		this.status=st;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String toString() {
		return "student model";
	}
	public int getSId() {
		return sId;
	}
	public void setSId(int sid) {
		this.sId=sid;
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
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public int getPassingYear() {
		return passingYear;
	}
	public void setPassingYear(int passingYear) {
		this.passingYear = passingYear;
	}
	
	
}
