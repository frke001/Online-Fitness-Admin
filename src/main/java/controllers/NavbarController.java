package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AdminBean;
import beans.CategoryBean;
import util.Pages;

/**
 * Servlet implementation class NavbarController
 */
@WebServlet("/NavbarController")
public class NavbarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavbarController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = Pages.CATEGORIES_PAGE;
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		AdminBean adminBean = (AdminBean) session.getAttribute("adminBean");

		if (adminBean == null || !adminBean.isLoggedIn()) {
			address = Pages.LOGIN_PAGE;
		} else {
			if (action == null || action.equals("")) {
				address = Pages.CATEGORIES_PAGE;
			} else if (action.equals("categories")) {
				address = Pages.CATEGORIES_PAGE;
			} else if (action.equals("users")) {
				address = Pages.USERS_PAGE;
			} else if (action.equals("statistics")) {
				address = Pages.STATISTICS_PAGE;
			} else {
				address = Pages.ERROR_PAGE;
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
