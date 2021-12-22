package com.sikiedu.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sikiedu.model.Order;

/**
 * Servlet implementation class GoodsLessenServlet
 */
@WebServlet("/goods_lessen")
public class GoodsLessenServlet extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order o = (Order) request.getSession().getAttribute("order");
		int goodsid = Integer.parseInt(request.getParameter("goodsid"));
		o.lessen(goodsid);
		response.getWriter().print("ok");
	}

}
