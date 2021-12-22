package com.sikiedu.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sikiedu.model.Page;
import com.sikiedu.service.GoodsService;

/**
 * Servlet implementation class GoodsRecommentList
 */
@WebServlet("/goodsrecommend_list")
public class GoodsRecommentListServlet extends HttpServlet {
	private GoodsService gService = new GoodsService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type = Integer.parseInt(request.getParameter("type") ) ;
		int pageNo = 1;
		if(request.getParameter("pageNo") != null) {
			pageNo=Integer.parseInt(request.getParameter("pageNo") ) ;
		}
		Page p = gService.getGoodsRecommendPage(type, pageNo);
		request.setAttribute("p", p);
		request.setAttribute("t", type);
		request.getRequestDispatcher("goodsrecommend_list.jsp").forward(request, response);
	}


}
