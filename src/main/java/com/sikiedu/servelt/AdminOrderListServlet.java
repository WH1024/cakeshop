package com.sikiedu.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sikiedu.model.Page;
import com.sikiedu.service.OrderService;

/**
 * Servlet implementation class AdminOrderListServlet
 */
@WebServlet("/admin/order_list")
public class AdminOrderListServlet extends HttpServlet {

	private OrderService oService = new OrderService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int status = 0;
		if(request.getParameter("status") != null) {
			status=Integer.parseInt(request.getParameter("status") ) ;
		}
		request.setAttribute("status", status);
		int pageNo = 1;
		if(request.getParameter("pageNo") != null) {
			pageNo=Integer.parseInt(request.getParameter("pageNo") ) ;
		}
		Page p = oService.getOrderPage(status,pageNo);
		request.setAttribute("p", p);
		request.getRequestDispatcher("/admin/order_list.jsp").forward(request, response);
	}
}
