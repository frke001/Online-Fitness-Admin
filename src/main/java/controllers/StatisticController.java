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
import beans.StatisticBean;
import util.Pages;

/**
 * Servlet implementation class StatisticController
 */
@WebServlet("/StatisticController")
public class StatisticController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisticController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = Pages.STATISTICS_PAGE;
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		AdminBean adminBean = (AdminBean) session.getAttribute("adminBean");
		
		if (adminBean == null || !adminBean.isLoggedIn()) {
			address = Pages.LOGIN_PAGE;
		} else {
			StatisticBean statisticBean = (StatisticBean) session.getAttribute("statisticBean");
			if (action == null || action.equals("")) {
				address = Pages.STATISTICS_PAGE;
				
			}else if(action.equals("page")) {
				if(request.getParameter("page") != null) {
					statisticBean.setCurrentPage(Integer.parseInt(request.getParameter("page")));
					System.out.println(statisticBean.getCurrentPage());
				}
				address = Pages.STATISTICS_PAGE;
			}
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
