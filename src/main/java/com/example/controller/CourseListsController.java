package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.example.DAO.CourseListsDAO;
import com.example.model.CourseListsModel;

/**
 * Servlet implementation class CourseListsController
 */
@WebServlet("/CourseListsServlet")
public class CourseListsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CourseListsDAO courseDAO = new CourseListsDAO();
        List<CourseListsModel> courseList = courseDAO.getAllCourses();
        for(CourseListsModel cl:courseList) {
        	System.out.println(cl.getcId());
        	System.out.println(cl.getCourseName());
        	System.out.println(cl.getCourseFee());
        	System.out.println(cl.getCourseDuration());
        	System.out.println(cl.getStatus());
        }

        
      
        if(courseList != null) {
	        request.setAttribute("courses", courseList);
	
	        RequestDispatcher dispatcher = request.getRequestDispatcher("courseList.jsp");
	        
	        dispatcher.include(request, response);
        }
        else {
        	RequestDispatcher rd1 = request.getRequestDispatcher("/errorpage.jsp");
			rd1.include(request, response);
        }
        
	}

}
