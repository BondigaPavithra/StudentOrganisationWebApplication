package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.model.FacultyModel;
import com.example.model.StudentModel;

public class StudentDAO {
	public String studentRegister(StudentModel sm) {
		String fname=sm.getFname();
		String lname=sm.getLname();
		String username=sm.getUsername();
		String pwd=sm.getPassword();
		long mobileNumber=sm.getMobile();
		String gender=sm.getGender();
		String address=sm.getAddress();
		int course=sm.getCid();
		String degree=sm.getDegree();
		String specialization=sm.getSpecialization();
		int passingYear=sm.getPassingYear() ;
		String studentStatus=sm.getStatus();
		
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(username);
		System.out.println(pwd);
		System.out.println(mobileNumber);
		System.out.println(gender);
		System.out.println(address);
		System.out.println(course);
		System.out.println(degree);
		System.out.println(specialization);
		System.out.println(passingYear);
		System.out.println(studentStatus);
		
		String status="fail";
		try {
			Connection con=AdminDBConnection.connect();	
			 String sql = "INSERT INTO students (fname, lname, username, studentPWD, mobile, gender, current_address, degree, specialization, year_of_passed,cId,studentStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setString(1, fname);           // assuming fname is a String
			 ps.setString(2, lname);           // assuming lname is a String
			 ps.setString(3, username);        // assuming username is a String
			 ps.setString(4, pwd);      // assuming studentPWD is a String
			 ps.setLong(5, mobileNumber);            // assuming mobile is a long or convert String to long
			 ps.setString(6, gender);          // assuming gender is a String
			 ps.setString(7, address);  // assuming currentAddress is a String
			 ps.setString(8, degree);          // assuming degree is a String
			 ps.setString(9, specialization);  // assuming specialization is a String
			 ps.setInt(10, passingYear); 
			 ps.setInt(11, course);
			 ps.setString(12, studentStatus);
			
			int n = ps.executeUpdate();
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
	
	
	public List<StudentModel> studentList() {
		List<StudentModel> sl = new ArrayList<>();
		try {
			Connection con = AdminDBConnection.connect();
			String str="SELECT s.*, c.courseName FROM students s JOIN courses c ON s.cId = c.cId";
			PreparedStatement ps = con.prepareStatement(str);
			ResultSet rs = ps.executeQuery();


			while (rs.next()) {
				StudentModel slm = new StudentModel(); 
				slm.setSId(rs.getInt("sId"));
				slm.setFname(rs.getString("fname"));
				slm.setLname(rs.getString("lname"));
				slm.setUsername(rs.getString("username"));
				slm.setPassword(rs.getString("studentPWD"));
				slm.setMobile(rs.getLong("mobile"));
				slm.setGender(rs.getString("gender"));
				slm.setAddress(rs.getString("current_address"));
				slm.setDegree(rs.getString("Degree"));
				slm.setSpecialization(rs.getString("specialization"));
				slm.setPassingYear(rs.getInt("year_of_passed"));
				slm.setCid(rs.getInt("cId"));
				slm.setCourseName(rs.getString("courseName"));
				slm.setStatus(rs.getString("studentStatus"));
				sl.add(slm);		
				
			}
			

		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return sl;
	}


	public String deleting(StudentModel sm) {
		String status="fail";
		System.out.println(sm.getSId());
		try {
			Connection con=AdminDBConnection.connect();	
			
			String str="DELETE FROM students WHERE sId = ?";
			PreparedStatement ps = con.prepareStatement(str);
			ps.setInt(1, sm.getSId());
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


	public List<StudentModel> getDataForEdit(StudentModel sm) {
		int sid=sm.getSId();
		List<StudentModel> sl = new ArrayList<>();
		try {
			Connection con=AdminDBConnection.connect();	
			String str="select *from students where sId=?";
			PreparedStatement ps = con.prepareStatement(str);
			ps.setInt(1, sid);
			
			ResultSet rs=ps.executeQuery();
			
			
			while (rs.next()) {
				StudentModel sme=new StudentModel();
				sme.setSId(rs.getInt("sId"));
				sme.setFname(rs.getString("fname"));
				sme.setLname(rs.getString("lname"));
				sme.setUsername(rs.getString("username"));
				sme.setPassword(rs.getString("studentPWD"));
				sme.setMobile(rs.getLong("mobile"));
				sme.setGender(rs.getString("gender"));
				sme.setAddress(rs.getString("current_address"));
				sme.setDegree(rs.getString("Degree"));
				sme.setSpecialization(rs.getString("specialization"));
				sme.setPassingYear(rs.getInt("year_of_passed"));
				sme.setCid(rs.getInt("cId"));
				sme.setStatus(rs.getString("studentStatus"));
				
				
				sl.add(sme); 
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		return sl;
		
	}


	public String updatestudent(StudentModel sm) {
		String status="fail";
		
		try {
			Connection con=AdminDBConnection.connect();	
			
			String str="UPDATE students SET fname=?, lname=?, username=?, studentPWD=?, mobile=?, gender=?, current_address=?,Degree=?,specialization=?,year_of_passed=?,cId=?,studentStatus=? WHERE sId=?";
			PreparedStatement ps = con.prepareStatement(str);
			 ps.setString(1, sm.getFname());           // assuming fname is a String
			 ps.setString(2, sm.getLname());           // assuming lname is a String
			 ps.setString(3, sm.getUsername());        // assuming username is a String
			 ps.setString(4, sm.getPassword());      // assuming studentPWD is a String
			 ps.setLong(5, sm.getMobile());            // assuming mobile is a long or convert String to long
			 ps.setString(6, sm.getGender());          // assuming gender is a String
			 ps.setString(7, sm.getAddress());  // assuming currentAddress is a String
			 ps.setString(8, sm.getDegree());
			 ps.setString(9, sm.getSpecialization());
			 ps.setInt(10, sm.getPassingYear());
			 ps.setInt(11, sm.getCid());
			 ps.setString(12, sm.getStatus());
			 ps.setInt(13, sm.getSId());
			
			int n=ps.executeUpdate();
		
			System.out.println("Executing SQL Query: " + ps.toString());
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
}
