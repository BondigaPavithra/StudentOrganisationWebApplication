package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.controller.EditCourseController;
import com.example.model.CourseListsModel;
import com.example.model.CourseModel;

public class CourseDAO {
	public String courseInsert(CourseModel cm) {
		String status="fail";
		String courseName=cm.getCourseName();
		int courseFee=cm.getCourseFee();
		int courseDuration=cm.getCourseDuration();
		String courseStatus=cm.getStatus();
		System.out.println(courseName);
		System.out.println(courseFee);
		System.out.println(courseDuration);
		
		try {
			Connection con=AdminDBConnection.connect();	
			String sql = "INSERT INTO courses (courseName, courseFee, courseDuration,CourseStatus) VALUES (?, ?, ?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, courseName);
			ps.setInt(2,courseFee );
			ps.setInt(3, courseDuration);
			ps.setString(4, courseStatus);
			int n=ps.executeUpdate();
			if(n>0) {
				System.out.println(n+" rows inserted");
				status="success";
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}

		return status;
	}
	public List<CourseModel> getDataForEdit(CourseModel cme) {
		
		int cid=cme.getcId();
		List<CourseModel> cl = new ArrayList<>();
		try {
			Connection con=AdminDBConnection.connect();	
			String str="select *from courses where cid=?";
			PreparedStatement ps = con.prepareStatement(str);
			ps.setInt(1, cid);
			
			ResultSet rs=ps.executeQuery();
			
			
			while (rs.next()) {
				CourseModel cm=new CourseModel();
				cm.setcId(rs.getInt("cId"));
				cm.setCourseName(rs.getString("courseName"));
				cm.setCourseFee(rs.getInt("courseFee"));
				cm.setCourseDuration(rs.getInt("courseDuration"));
				cm.setStatus(rs.getString("CourseStatus"));
				cl.add(cm); 
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return cl;
	}
	public String updateCourse(CourseModel cmu) {
		String status="fail";
		
		System.out.println(cmu.getStatus());
		try {
			Connection con=AdminDBConnection.connect();	
			
			String str="UPDATE courses SET courseName = ?, courseFee = ?,courseDuration=?,CourseStatus=? WHERE cId=?";
			PreparedStatement ps = con.prepareStatement(str);
			ps.setString(1, cmu.getCourseName());
			ps.setInt(2,cmu.getCourseFee() );
			ps.setInt(3, cmu.getCourseDuration());
			ps.setString(4, cmu.getStatus());
			ps.setInt(5, cmu.getcId());
			
			int n=ps.executeUpdate();
			
			if(n>0) {
				System.out.println(n+" rows updated");
				status="success";
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public String deleting(CourseModel cm) {
		String status="fail";
		System.out.println(cm.getcId());
		try {
			Connection con=AdminDBConnection.connect();	
			
			String str="DELETE FROM courses WHERE cId = ?";
			PreparedStatement ps = con.prepareStatement(str);
			ps.setInt(1, cm.getcId());
			int n=ps.executeUpdate();
			if(n>0) {
				System.out.println(n+" rows deleted");
				status="success";
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
