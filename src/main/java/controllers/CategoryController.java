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
import dto.CategoryDTO;
import dto.RequestAttributeDTO;
import dto.RequestCategoryDTO;
import util.Pages;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryController() {
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
			CategoryBean categoryBean = (CategoryBean) session.getAttribute("categoryBean");
			if (action == null || action.equals("")) {
				address = Pages.CATEGORIES_PAGE;
			} else if (action.equals("addCategory")) {

				String name = request.getParameter("name");
				if (request.getParameter("submit") != null && name != null) {
					RequestCategoryDTO requestCategoryDTO = new RequestCategoryDTO(name);
					if(categoryBean.insertCategory(requestCategoryDTO)) {
						session.setAttribute("categorySuccess", "true");
					}else {
						session.setAttribute("categoryUnsuccess", "true");
					}
				}
			} else if (action.equals("deleteCategory")) {
				Long id = Long.parseLong(request.getParameter("id"));
				if (id != null) {
					if(categoryBean.deleteCategory(id)) {
						session.setAttribute("categorySuccess", "true");
					}else {
						session.setAttribute("categoryUnsuccess", "true");
					}
				}
			} else if (action.equals("modifyCategory")) {

				if (request.getParameter("submit") != null && request.getParameter("categoryId") != null
						&& request.getParameter("name") != null) {
					Long id = Long.parseLong(request.getParameter("categoryId"));
					String name = request.getParameter("name");
					if(categoryBean.updateCategory(id, new RequestCategoryDTO(name))) {
						session.setAttribute("categorySuccess", "true");
					}else {
						session.setAttribute("categoryUnsuccess", "true");
					}
				}
			} else if (action.equals("addAttribute")) {

				if (request.getParameter("submit") != null && request.getParameter("categoryId") != null
						&& request.getParameter("name") != null) {
					Long id = Long.parseLong(request.getParameter("categoryId"));
					String name = request.getParameter("name");
					if(categoryBean.addAttributeForCategory(id, new RequestAttributeDTO(name))) {
						session.setAttribute("categorySuccess", "true");
					}else {
						session.setAttribute("categoryUnsuccess", "true");
					}
				}
			}else if (action.equals("deleteAttribute")) {

				if (request.getParameter("id") != null) {
					if(categoryBean.deleteAttribute(Long.parseLong(request.getParameter("id")))) {
						session.setAttribute("categorySuccess", "true");
					}else {
						session.setAttribute("categoryUnsuccess", "true");
					}
				}
			}else {
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
