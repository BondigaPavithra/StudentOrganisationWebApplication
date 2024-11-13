package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.example.DAO.StudentDAO;
import com.example.model.StudentModel;

/**
 * Servlet implementation class StudentEditController1
 */
@WebServlet("/studentedit")
public class StudentEditController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
        int studentId = 0;
        try {
        	studentId = Integer.parseInt(sid);
        } catch (NumberFormatException e) {
            System.out.println("Invalid course ID");
        }
        System.out.println(studentId);
        
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
		
		String degree=request.getParameter("degree");
		System.out.println(degree);
		String specialization=request.getParameter("specialization");
		System.out.println(specialization);
		String year_of_passed=request.getParameter("year_of_passed");
		int passingYear = 0;
        try {
            passingYear = Integer.parseInt(year_of_passed);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
		System.out.println(passingYear);
		String studentStatus=request.getParameter("status");
		
		StudentModel sm=new StudentModel();
		sm.setSId(studentId);
		sm.setFname(fname);
		sm.setLname(lname);
		sm.setUsername(username);
		sm.setPassword(pwd);
		sm.setMobile(mobileNumber);
		sm.setGender(gender);
		sm.setAddress(address);
		sm.setCid(cid);
		sm.setDegree(degree);
		sm.setSpecialization(specialization);
		sm.setPassingYear(passingYear);
		sm.setStatus(studentStatus);
		
		StudentDAO sd=new StudentDAO();
		String status=sd.updatestudent(sm);
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
