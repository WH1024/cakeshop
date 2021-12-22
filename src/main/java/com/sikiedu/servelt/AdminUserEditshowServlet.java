package com.sikiedu.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sikiedu.model.User;
import com.sikiedu.service.UserService;

/**
 * Servlet implementation class AdminUserEditshowServlet
 */
@WebServlet("/admin/user_editshow")
public class AdminUserEditshowServlet extends HttpServlet {
	
	private UserService uService = new UserService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = uService.selectById(id);
		request.setAttribute("u", user);
		request.getRequestDispatcher("/admin/user_edit.jsp").forward(request, response);
	}


}
