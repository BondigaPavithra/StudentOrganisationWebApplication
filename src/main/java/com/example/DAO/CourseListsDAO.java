package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.model.CourseListsModel;

public class CourseListsDAO {

	public List<CourseListsModel> getAllCourses() {
		List<CourseListsModel> cl = new ArrayList<>();
		System.out.println("this is course list informatiom");
		try {
			Connection con = AdminDBConnection.connect();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM courses");
			ResultSet rs = ps.executeQuery();

			System.out.println(" hello courselist");

			while (rs.next()) {
				CourseListsModel clm = new CourseListsModel(); 
				clm.setcId(rs.getInt("cId"));
				clm.setCourseName(rs.getString("courseName"));
				clm.setCourseFee(rs.getInt("courseFee"));
				clm.setCourseDuration(rs.getInt("courseDuration"));
				clm.setStatus(rs.getString("CourseStatus"));
				cl.add(clm); 
			}
			

		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return cl; 
	}
}
