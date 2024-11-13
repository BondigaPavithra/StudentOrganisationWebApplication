package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.example.model.AdminModel;


public class AdminDAO {
	
	
	public String adminlogin(AdminModel am)  {
		String status="fail";
		
		String uname=am.getUsername();
		String pwd=am.getAdminpwd();
		String role=am.getRole();
		
		if(role.equals("Admin")) {
			try {
				Connection con=AdminDBConnection.connect();	
				PreparedStatement ps=con.prepareStatement("select *from hradmin where username=? and adminpwd=?");
				ps.setString(1, uname);
				ps.setString(2, pwd);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					
					
					status = "Admin";
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
		if(role.equals("Student")) {
			try {
				Connection con=AdminDBConnection.connect();	
				PreparedStatement ps=con.prepareStatement("select *from students where username=? and studentPWD=?");
				ps.setString(1, uname);
				ps.setString(2, pwd);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					
					
					status = "Student";
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
		if(role.equals("Faculty")) {
			try {
				Connection con=AdminDBConnection.connect();	
				PreparedStatement ps=con.prepareStatement("select *from faculties where username=? and facultyPWD=?");
				ps.setString(1, uname);
				ps.setString(2, pwd);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					
					
					status = "Faculty";
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
		
		
		return status;
	}
}
