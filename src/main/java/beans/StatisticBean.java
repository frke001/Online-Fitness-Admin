package beans;

import java.io.Serializable;
import java.util.List;

import dao.LogDAO;
import dto.LogDTO;
import mysql.LogDAOImpl;

public class StatisticBean implements Serializable{

	private static final long serialVersionUID = -5978800878496728641L;
	private Integer pageSize = 10;
	private Integer totalPages;
	private Integer currentPage = 1;
	LogDAO logDAO = new LogDAOImpl();
	public StatisticBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getTotalPages(int pageSize) {
		return logDAO.getTotalPages(pageSize);
	}
	
	public List<LogDTO> getLogsByPage(int pageSize, int pageNumber){
		return logDAO.getLogsByPage(pageSize, pageNumber);
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

}
