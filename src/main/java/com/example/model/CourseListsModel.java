package com.example.model;

public class CourseListsModel {
	private int cId;
	private String courseName;
	private int courseFee;
	private int courseDuration;
	private String status;
	public CourseListsModel() {
		
	}
	public CourseListsModel(int cid,String cname,int cfee,int cduration,String st) {
		this.cId=cid;
		this.courseName=cname;
		this.courseFee=cfee;
		this.courseDuration=cduration;
		this.status=st;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String toString() {
		return "hii";
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}
	public int getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}
}
