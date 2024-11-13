package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.example.DAO.FacultyDAO;
import com.example.model.FacultyModel;

/**
 * Servlet implementation class FacultyListsController
 */
@WebServlet("/FacultyListsServlet")
public class FacultyListsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacultyDAO fd=new FacultyDAO();
		List<FacultyModel> list=fd.facultyList();
		
		if(list != null) {
			request.setAttribute("faculty", list);
	
	        RequestDispatcher dispatcher = request.getRequestDispatcher("facultyList.jsp");
	        
	        dispatcher.include(request, response);
		}
		else {
        	RequestDispatcher rd1 = request.getRequestDispatcher("/errorpage.jsp");
			rd1.include(request, response);
        }
	}

}
