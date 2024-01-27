package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.LogDAO;
import dto.AdminDTO;
import dto.AdvisorDTO;
import dto.LogDTO;
import dto.LoginDTO;
import util.DBUtil;

public class LogDAOImpl implements LogDAO{
	
	private static final String SQL_SELECT_WITH_PAGINATION = "SELECT * FROM log ORDER BY creation_date DESC LIMIT ? OFFSET ?";
	private static final String SQL_COUNT_TOTAL_ROWS = "SELECT COUNT(*) AS total_rows FROM log";
	@Override
	public List<LogDTO> getLogsByPage(int pageSize, int pageNumber) {
		List<LogDTO> logs = new ArrayList<LogDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int offset = (pageNumber - 1) * pageSize;
		Object values[] = {pageSize, offset};
		try {
			connection = DBUtil.getConnection();
			preparedStatement = DBUtil.prepareStatement(connection, SQL_SELECT_WITH_PAGINATION, false, values);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				logs.add(new LogDTO(resultSet.getLong("id"),resultSet.getString("level"),resultSet.getString("message"),
						resultSet.getDate("creation_date")));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet,preparedStatement,connection);
		}
		return logs;
	}

	@Override
	public Integer getTotalPages(int pageSize) {
		Integer totalRows = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Object values[] = {};
		try {
			connection = DBUtil.getConnection();
			preparedStatement = DBUtil.prepareStatement(connection, SQL_COUNT_TOTAL_ROWS, false, values);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				totalRows = resultSet.getInt("total_rows");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(resultSet,preparedStatement,connection);
		}
		Integer totalPages = (int) Math.ceil((double) totalRows / pageSize);
		return totalPages;
	}

}
