package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.example.DAO.FacultyDAO;
import com.example.DAO.StudentDAO;
import com.example.model.FacultyModel;
import com.example.model.StudentModel;

/**
 * Servlet implementation class StudentDeleteController
 */
@WebServlet("/studentDeleting")
public class StudentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("sid");
	    System.out.println(id);
	    int sid=Integer.parseInt(id);
	    
	    StudentModel sm=new StudentModel();
	    sm.setSId(sid);
	    
	    StudentDAO sd=new StudentDAO();
	    String status=sd.deleting(sm);
	    
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
