package com.sikiedu.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sikiedu.model.Page;
import com.sikiedu.service.UserService;

/**
 * Servlet implementation class AdminUserListServlet
 */
@WebServlet("/admin/user_list")
public class AdminUserListServlet extends HttpServlet {
	
	private UserService uService = new UserService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo = 1;
		if(request.getParameter("pageNo") != null) {
			pageNo=Integer.parseInt(request.getParameter("pageNo") ) ;
		}
		Page p = uService.getUserPage(pageNo);
		request.setAttribute("p", p);
		request.getRequestDispatcher("/admin/user_list.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	

}
