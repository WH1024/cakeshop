package com.sikiedu.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sikiedu.service.OrderService;

/**
 * Servlet implementation class AdminOrderDeleteServlet
 */
@WebServlet("/admin/order_delete")
public class AdminOrderDeleteServlet extends HttpServlet {

	private OrderService oService = new OrderService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		oService.delete(id);
		request.getRequestDispatcher("/admin/order_list").forward(request, response);
	}

}
