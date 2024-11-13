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
import com.example.DAO.StudentDAO;
import com.example.model.FacultyModel;
import com.example.model.StudentModel;

/**
 * Servlet implementation class StudentEditController
 */
@WebServlet("/studentupdating")
public class StudentEditController extends HttpServlet {
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
	    List<StudentModel> list=sd.getDataForEdit(sm);
	    for(StudentModel x:list) {
	    	System.out.println(x.getSId());
	    	System.out.println(x.getFname());
	    	System.out.println(x.getLname());
	    	
	    }
	    
	    if(list != null) {
		    request.setAttribute("student", list);
	
	        RequestDispatcher dispatcher = request.getRequestDispatcher("studentEdit.jsp");
	        
	        dispatcher.include(request, response);
	    }
	    else {
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("errorpage.jsp");
	        
	        dispatcher.include(request, response);
	    }
	}

}
