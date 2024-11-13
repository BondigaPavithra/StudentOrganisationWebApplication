package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.DAO.AdminDBConnection;
import com.example.DAO.CourseListsDAO;
import com.example.DAO.StudentDAO;
import com.example.model.CourseListsModel;
import com.example.model.StudentModel;

/**
 * Servlet implementation class StudentListsController
 */
@WebServlet("/StudentListsServlet")
public class StudentListsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDAO stu = new StudentDAO();
        List<StudentModel> list = stu.studentList();
        for(StudentModel sl:list) {
        	System.out.println(sl.getSId());
        	System.out.println(sl.getFname());
        	System.out.println(sl.getLname());
        	System.out.println(sl.getUsername());
        }
        if(list != null) {
	        request.setAttribute("student", list);
	
	        RequestDispatcher dispatcher = request.getRequestDispatcher("studentList.jsp");
	        
	        dispatcher.include(request, response);
		}
		else {
	    	RequestDispatcher rd1 = request.getRequestDispatcher("/errorpage.jsp");
			rd1.include(request, response);
	    }
	}

}
