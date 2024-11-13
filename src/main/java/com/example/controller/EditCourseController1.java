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
 * Servlet implementation class EditCourseController1
 */
@WebServlet("/edit")
public class EditCourseController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseIdStr = request.getParameter("cid");
        int courseId = 0;
        try {
            courseId = Integer.parseInt(courseIdStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid course ID");
        }
        System.out.println(courseId);
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
		String coursestatus=request.getParameter("courseStatus");
		System.out.println(coursestatus);
		 
		CourseModel cm=new CourseModel();
		cm.setcId(courseId);
		cm.setCourseName(courseName);
		cm.setCourseFee(courseFee);
		cm.setCourseDuration(courseDuration);
		cm.setStatus(coursestatus);
		CourseDAO cd=new CourseDAO();
		String status=cd.updateCourse(cm);
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
