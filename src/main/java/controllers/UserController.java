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
import beans.UserBean;
import dto.RequestAdvisorDTO;
import util.Pages;

/**
 * Servlet implementation class ClientController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = Pages.USERS_PAGE;
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		AdminBean adminBean = (AdminBean) session.getAttribute("adminBean");
		session.setAttribute("clients", true);
		if (adminBean == null || !adminBean.isLoggedIn()) {
			address = Pages.LOGIN_PAGE;
		} else {
			UserBean userBean = (UserBean) session.getAttribute("userBean");
			if (action == null || action.equals("")) {
				address = Pages.USERS_PAGE;
			} else if (action.equals("blockUser")) {
				if(request.getParameter("id") != null) {
					if(userBean.blockUnblockClient(Long.parseLong(request.getParameter("id")), true)) {
						session.setAttribute("showToastAdvisorSuccess", "true");
					}else {
						session.setAttribute("showToastAdvisor", "true");
					}
				}
				session.setAttribute("clients", true);
				
			}else if (action.equals("unblockUser")) {
				if(request.getParameter("id") != null) {
					if(userBean.blockUnblockClient(Long.parseLong(request.getParameter("id")), false)) {
						session.setAttribute("showToastAdvisorSuccess", "true");
					}else {
						session.setAttribute("showToastAdvisor", "true");
					}
				}
				session.setAttribute("clients", true);
			}
			else if (action.equals("blockAdvisor")) {
				if(request.getParameter("id") != null) {
				 	if(userBean.blockUnblocAdvisor(Long.parseLong(request.getParameter("id")), true)) {
				 		session.setAttribute("showToastAdvisorSuccess", "true");
				 	}else {
				 		session.setAttribute("showToastAdvisor", "true");
					}
				}
				session.setAttribute("clients", false);
			}else if (action.equals("unblockAdvisor")) {
				if(request.getParameter("id") != null) {
					if(userBean.blockUnblocAdvisor(Long.parseLong(request.getParameter("id")), false)) {
						session.setAttribute("showToastAdvisorSuccess", "true");
					}else {
						session.setAttribute("showToastAdvisor", "true");
					}
				}
				session.setAttribute("clients", false);
			}else if(action.equals("addAdvisor")) {
				if(request.getParameter("submit") != null && request.getParameter("name") != null  && request.getParameter("surname") != null
						 && request.getParameter("username") != null && request.getParameter("password") != null
						 && request.getParameter("retypePassword") != null && request.getParameter("mail") != null) {
					RequestAdvisorDTO requestAdvisorDTO = new RequestAdvisorDTO(request.getParameter("name"),request.getParameter("surname"),
							request.getParameter("username"),request.getParameter("password"),request.getParameter("mail"));
					if(userBean.insertAdvisor(requestAdvisorDTO)) {
						session.setAttribute("showToastAdvisorSuccess", "true");
					}else {
						session.setAttribute("showToastAdvisor", "true");
					}
				}
				session.setAttribute("clients", false);
			}else {
				address = Pages.ERROR_PAGE;
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
