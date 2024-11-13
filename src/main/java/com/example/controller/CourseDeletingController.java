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
 * Servlet implementation class CourseDeletingController
 */
@WebServlet("/deletingCourse")
public class CourseDeletingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("cid");
	    System.out.println(id);
	    int cid=Integer.parseInt(id);
	    
	    CourseModel cm=new CourseModel();
	    cm.setcId(cid);
	    
	    CourseDAO cd=new CourseDAO();
	    String status=cd.deleting(cm);
	    
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
