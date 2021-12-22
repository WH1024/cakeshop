package com.sikiedu.servelt;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.sikiedu.model.User;
import com.sikiedu.service.UserService;

/**
 * Servlet implementation class UserChangeAddressServlet
 */
@WebServlet("/user_changeaddress")
public class UserChangeAddressServlet extends HttpServlet {
	
	private UserService uService = new UserService();
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User loginUser = (User) request.getSession().getAttribute("user");
		
		try {
			BeanUtils.copyProperties(loginUser, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uService.updateUserAddress(loginUser);
		request.setAttribute("msg", "收件信息更新成功！");
		request.getRequestDispatcher("/user_center.jsp").forward(request, response);
	}

}
