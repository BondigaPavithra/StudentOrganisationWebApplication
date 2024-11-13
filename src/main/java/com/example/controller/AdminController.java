package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.example.DAO.AdminDAO;
import com.example.model.AdminModel;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/register")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("admin controller");
		String username=request.getParameter("username");
		
		String adminpwd=request.getParameter("password");
		
		String role=request.getParameter("role");
		
		
		System.out.println(username);
		System.out.println(adminpwd);
		System.out.println(role);
		
		
		AdminModel am=new AdminModel();
		am.setUsername(username);
		am.setAdminpwd(adminpwd);
		am.setRole(role);
		
		AdminDAO ad=new AdminDAO();
		String status=ad.adminlogin(am);
		
		HttpSession session = request.getSession();
		if(status.equals("Admin")) {
			session.setAttribute("username", username);
			RequestDispatcher rd1 = request.getRequestDispatcher("/adminhome.jsp");
			rd1.include(request, response);
		}
		
		else if(status.equals("Student")) {
			session.setAttribute("username", username);
			RequestDispatcher rd1 = request.getRequestDispatcher("/studenthome.jsp");
			rd1.include(request, response);
			
		}
		else if(status.equals("Faculty")) {
			session.setAttribute("username", username);
			RequestDispatcher rd1 = request.getRequestDispatcher("/facultyhome.jsp");
			rd1.include(request, response);
		}
		else {
			RequestDispatcher rd1 = request.getRequestDispatcher("/index.html");
			rd1.include(request, response);
		}
	}

}
