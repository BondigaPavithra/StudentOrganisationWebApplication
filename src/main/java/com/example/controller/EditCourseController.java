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
import com.example.model.CourseModel;

/**
 * Servlet implementation class EditCourseController
 */
@WebServlet("/coursedelete")
public class EditCourseController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String id = request.getParameter("cid");
	    System.out.println(id+" yesssssssssssssssssssssssss22");
	    int cid=Integer.parseInt(id);
	    
	    CourseModel cm=new CourseModel();
	    cm.setcId(cid);
	    
	    CourseDAO cd=new CourseDAO();
	    List<CourseModel> list=cd.getDataForEdit(cm);
	    for(CourseModel x:list) {
	    	System.out.println(x.getcId());
	    	System.out.println(x.getCourseName());
	    	System.out.println(x.getCourseDuration());
	    	System.out.println(x.getCourseFee());
	    	System.out.println(x.getStatus());
	    }
	    
	    if(list != null) {
		    request.setAttribute("courses", list);
	
	        RequestDispatcher dispatcher = request.getRequestDispatcher("courseEdit.jsp");
	        
	        dispatcher.include(request, response);
	    }
	    else {
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("errorpage.jsp");
	        
	        dispatcher.include(request, response);
	    }
	}


}
