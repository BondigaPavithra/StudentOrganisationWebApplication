package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.example.DAO.FacultyDAO;
import com.example.model.FacultyModel;

/**
 * Servlet implementation class Facultyservlet
 */
@WebServlet("/faculty_register")
public class FacultyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("firstname");
		System.out.println(fname);
		String lname=request.getParameter("lastname");
		System.out.println(lname);
		String username=request.getParameter("username");
		System.out.println(username);
		String pwd=request.getParameter("password");
		System.out.println(pwd);
		String mobile = request.getParameter("mobile");

        // Convert the mobile number to a long
        long mobileNumber = 0;
        try {
            mobileNumber = Long.parseLong(mobile);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        
		System.out.println(mobileNumber);
		String gender=request.getParameter("gender");
		System.out.println(gender);
		String address=request.getParameter("address");
		System.out.println(address);
		String course=request.getParameter("course");
		int cid = 0;
        try {
            cid = Integer.parseInt(course);
        } catch (Exception e) {
            System.out.println(e);
        }
		System.out.println(cid);
		
		String exp=request.getParameter("year_of_exp");
		int year_of_exp=0;
		try {
			year_of_exp=Integer.parseInt(exp);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(year_of_exp);
		String facultyStatus=request.getParameter("status");
		System.out.println(facultyStatus);
		
		
		FacultyModel fm=new FacultyModel();
		fm.setFname(fname);
		fm.setLname(lname);
		fm.setUsername(username);
		fm.setPassword(pwd);
		fm.setMobile(mobileNumber);
		fm.setGender(gender);
		fm.setAddress(address);
		fm.setCid(cid);
		fm.setYear_of_exp(year_of_exp);
		fm.setStatus(facultyStatus);
		
		FacultyDAO fd=new FacultyDAO();
		String status=fd.facultyRegister(fm);
		if(status.equals("success")) {
			RequestDispatcher rd1 = request.getRequestDispatcher("/adminhome.jsp");
			rd1.include(request, response);
		}
		else {
			RequestDispatcher rd1 = request.getRequestDispatcher("/errorpage.jsp");
			rd1.include(request, response);
		}
	}

}
