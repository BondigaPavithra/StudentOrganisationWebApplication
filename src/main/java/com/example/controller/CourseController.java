package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.example.DAO.CourseDAO;
import com.example.model.CourseModel;

/**
 * Servlet implementation class CourseController
 */
@WebServlet("/course_register")
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseName=request.getParameter("coursename");
		System.out.println(courseName);
		String coursefee=request.getParameter("coursefee");
		int courseFee=0;
        try {
        	courseFee = Integer.parseInt(coursefee);
        } catch (Exception e) {
            System.out.println(e);
        }
		System.out.println(courseFee);
		String courseduration=request.getParameter("courseduration");
		int courseDuration=0;
        try {
        	courseDuration = Integer.parseInt(courseduration);
        } catch (Exception e) {
            System.out.println(e);
        }
		System.out.println(courseDuration);
		String courseStatus=request.getParameter("status");
		
		CourseModel cm=new CourseModel();
		cm.setCourseName(courseName);
		cm.setCourseFee(courseFee);
		cm.setCourseDuration(courseDuration);
		cm.setStatus(courseStatus);
		
		CourseDAO cd=new CourseDAO();
		String status=cd.courseInsert(cm);
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
