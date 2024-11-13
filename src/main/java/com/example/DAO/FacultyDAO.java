package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.model.CourseModel;
import com.example.model.FacultyModel;
import com.example.model.StudentModel;


public class FacultyDAO {
	public String facultyRegister(FacultyModel fm) {
		String fname=fm.getFname();
		String lname=fm.getLname();
		String username=fm.getUsername();
		String pwd=fm.getPassword();
		long mobileNumber=fm.getMobile();
		String gender=fm.getGender();
		String address=fm.getAddress();
		int course=fm.getCid();
		int year_of_exp=fm.getYear_of_exp() ;
		String facultyStatus=fm.getStatus();
		
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(username);
		System.out.println(pwd);
		System.out.println(mobileNumber);
		System.out.println(gender);
		System.out.println(address);
		System.out.println(course);
		System.out.println(year_of_exp);
		System.out.println(facultyStatus);
		
		String status="fail";
		try {
			Connection con=AdminDBConnection.connect();	
			 String sql = "INSERT INTO faculties (fname, lname, username, facultyPWD, mobile, gender, current_address,year_of_experience,cId,facultyStatus ) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setString(1, fname);           // assuming fname is a String
			 ps.setString(2, lname);           // assuming lname is a String
			 ps.setString(3, username);        // assuming username is a String
			 ps.setString(4, pwd);      // assuming studentPWD is a String
			 ps.setLong(5, mobileNumber);            // assuming mobile is a long or convert String to long
			 ps.setString(6, gender);          // assuming gender is a String
			 ps.setString(7, address);  // assuming currentAddress is a String
			 ps.setInt(8, year_of_exp);
			 ps.setInt(9, course);// assuming degree is a String
			 ps.setString(10, facultyStatus);
			   
			
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
	
	public List<FacultyModel> facultyList() {
		List<FacultyModel> sl = new ArrayList<>();
		try {
			Connection con = AdminDBConnection.connect();
			String str="SELECT f.*, c.courseName FROM faculties f JOIN courses c ON f.cId = c.cId;";
			PreparedStatement ps = con.prepareStatement(str);
			ResultSet rs = ps.executeQuery();

			System.out.println(" hello faculty list");

			while (rs.next()) {
				FacultyModel flm = new FacultyModel(); 
				flm.setfId(rs.getInt("fId"));
				flm.setFname(rs.getString("fname"));
				flm.setLname(rs.getString("lname"));
				flm.setUsername(rs.getString("username"));
				flm.setPassword(rs.getString("facultyPWD"));
				flm.setMobile(rs.getLong("mobile"));
				flm.setGender(rs.getString("gender"));
				flm.setYear_of_exp(rs.getInt("year_of_experience"));
				flm.setAddress(rs.getString("current_address"));
				flm.setCid(rs.getInt("cId"));
				flm.setCourseName(rs.getString("courseName"));
				flm.setStatus(rs.getString("facultyStatus"));
				sl.add(flm);		
				
			}
			

			System.out.println(" hello courselist");

		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return sl;

	}

	public List<FacultyModel> getDataForEdit(FacultyModel fm) {
		int fid=fm.getfId();
		List<FacultyModel> fl = new ArrayList<>();
		try {
			Connection con=AdminDBConnection.connect();	
			String str="select *from faculties where fId=?";
			PreparedStatement ps = con.prepareStatement(str);
			ps.setInt(1, fid);
			
			ResultSet rs=ps.executeQuery();
			
			
			while (rs.next()) {
				FacultyModel fme=new FacultyModel();
				fme.setfId(rs.getInt("fId"));
				fme.setFname(rs.getString("fname"));
				fme.setLname(rs.getString("lname"));
				fme.setUsername(rs.getString("username"));
				fme.setPassword(rs.getString("facultyPWD"));
				fme.setMobile(rs.getLong("mobile"));
				fme.setGender(rs.getString("gender"));
				fme.setAddress(rs.getString("current_address"));
				fme.setYear_of_exp(rs.getInt("year_of_experience"));
				fme.setCid(rs.getInt("cId"));
				fme.setStatus(rs.getString("facultyStatus"));
				
				
				fl.add(fme); 
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		return fl;
	}

	public String updatefaculty(FacultyModel fm) {
		String status="fail";
		
		try {
			Connection con=AdminDBConnection.connect();	
			
			String str="UPDATE faculties SET fname=?, lname=?, username=?, facultyPWD=?, mobile=?, gender=?, current_address=?,year_of_experience=?,cId=?,facultyStatus=? WHERE fId=?";
			PreparedStatement ps = con.prepareStatement(str);
			 ps.setString(1, fm.getFname());           // assuming fname is a String
			 ps.setString(2, fm.getLname());           // assuming lname is a String
			 ps.setString(3, fm.getUsername());        // assuming username is a String
			 ps.setString(4, fm.getPassword());      // assuming studentPWD is a String
			 ps.setLong(5, fm.getMobile());            // assuming mobile is a long or convert String to long
			 ps.setString(6, fm.getGender());          // assuming gender is a String
			 ps.setString(7, fm.getAddress());  // assuming currentAddress is a String
			 ps.setInt(8, fm.getYear_of_exp());
			 ps.setInt(9, fm.getCid());
			 ps.setString(10, fm.getStatus());
			 ps.setInt(11, fm.getfId());
			 
			
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

	public String deleting(FacultyModel cm) {
		String status="fail";
		System.out.println(cm.getfId());
		try {
			Connection con=AdminDBConnection.connect();	
			
			String str="DELETE FROM faculties WHERE fId = ?";
			PreparedStatement ps = con.prepareStatement(str);
			ps.setInt(1, cm.getfId());
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
