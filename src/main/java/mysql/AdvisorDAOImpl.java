package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dao.AdvisorDAO;
import dto.AdvisorDTO;
import dto.ClientDTO;
import dto.RequestAdvisorDTO;
import util.DBUtil;

public class AdvisorDAOImpl implements AdvisorDAO {

	private static final String SQL_SELECT_ALL = "SELECT * FROM advisor";
	private static final String SQL_UPDATE_ADVISOR = "UPDATE advisor SET deleted=? WHERE id=?";
	private static final String SQL_INSERT_ADVISOR = "INSERT INTO advisor (name, surname, username, password, mail, deleted) VALUES (?,?,?,?,?,?)";
	@Override
	public List<AdvisorDTO> getAll() {
		List<AdvisorDTO> advisors = new ArrayList<AdvisorDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Object values[] = {};
		try {
			connection = DBUtil.getConnection();
			preparedStatement = DBUtil.prepareStatement(connection, SQL_SELECT_ALL, false, values);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				advisors.add(new AdvisorDTO(resultSet.getLong("id"),resultSet.getString("name"),resultSet.getString("surname"),
						resultSet.getString("username"),resultSet.getString("mail"),
						resultSet.getBoolean("deleted")));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet,preparedStatement,connection);
		}
		return advisors;
	}
	@Override
	public boolean blockUnblocAdvisor(Long id, Boolean block) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Object[] values = {block, id};
		try {
			connection = DBUtil.getConnection();
			preparedStatement = DBUtil.prepareStatement(connection, SQL_UPDATE_ADVISOR, true, values);
			int count = preparedStatement.executeUpdate();
			if(count > 0) {
				result = true;
			}
		}catch (Exception e) {
			//e.printStackTrace();
			return result;
		}finally {
			DBUtil.close(resultSet,preparedStatement,connection);
		}
		return result;
	}
	@Override
	public boolean insert(RequestAdvisorDTO requestAdvisorDTO) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		String hashedPasswordString = encoder.encode(requestAdvisorDTO.getPassword());
		Object[] values = {requestAdvisorDTO.getName(), requestAdvisorDTO.getSurname(),
				requestAdvisorDTO.getUsername(), hashedPasswordString, requestAdvisorDTO.getMail(), false};
		try {
			connection = DBUtil.getConnection();
			preparedStatement = DBUtil.prepareStatement(connection, SQL_INSERT_ADVISOR, true, values);
			int count = preparedStatement.executeUpdate();
			if(count > 0) {
				result = true;
			}
		}catch (Exception e) {
			//e.printStackTrace();
			return result;
		}finally {
			DBUtil.close(resultSet,preparedStatement,connection);
		}
		return result;
	}

}
