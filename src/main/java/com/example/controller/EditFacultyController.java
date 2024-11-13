package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.example.DAO.CourseDAO;
import com.example.DAO.FacultyDAO;
import com.example.model.CourseModel;
import com.example.model.FacultyModel;

/**
 * Servlet implementation class EditFacultyController
 */
@WebServlet("/updating")
public class EditFacultyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("fid");
	    System.out.println(id);
	    int fid=Integer.parseInt(id);
	    
	    FacultyModel fm=new FacultyModel();
	    fm.setfId(fid);
	    
	    FacultyDAO fd=new FacultyDAO();
	    List<FacultyModel> list=fd.getDataForEdit(fm);
	    for(FacultyModel x:list) {
	    	System.out.println(x.getfId());
	    	System.out.println(x.getFname());
	    	System.out.println(x.getLname());
	    	
	    	
	    }
	    
	    if(list != null) {
		    request.setAttribute("faculty", list);
	
	        RequestDispatcher dispatcher = request.getRequestDispatcher("facultyEdit.jsp");
	        
	        dispatcher.include(request, response);
	    }
	    else {
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("errorpage.jsp");
	        
	        dispatcher.include(request, response);
	    }
	}

}
