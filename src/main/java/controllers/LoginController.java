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
import beans.StatisticBean;
import beans.UserBean;
import dto.AdminDTO;
import dto.LoginDTO;
import util.Pages;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = Pages.LOGIN_PAGE;
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		session.setAttribute("notification", "");
		if(action == null || action.equals("")) {
			address = Pages.LOGIN_PAGE;
		}else if(action.equals("login")) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			AdminBean adminBean = new AdminBean();
			if(adminBean.login(new LoginDTO(username,password))) {
				address = Pages.CATEGORIES_PAGE;
				session.setAttribute("adminBean", adminBean);
				
				CategoryBean categoryBean = new CategoryBean();
				session.setAttribute("categoryBean", categoryBean);
				UserBean userBean = new UserBean();
				session.setAttribute("userBean", userBean);
				session.setAttribute("clients", true);
				StatisticBean statisticBean = new StatisticBean();
				session.setAttribute("statisticBean", statisticBean);
				//session.setAttribute("advisors", true);
			}else {
				session.setAttribute("notification", "Incorrect credentials!");
			}
		}else if(action.equals("logout")) {
			session.invalidate();
			address = Pages.LOGIN_PAGE;
		}else {
			address = Pages.ERROR_PAGE;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
