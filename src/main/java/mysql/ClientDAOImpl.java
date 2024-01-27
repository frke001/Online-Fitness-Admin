package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ClientDAO;
import dto.CategoryDTO;
import dto.ClientDTO;
import util.DBUtil;

public class ClientDAOImpl implements ClientDAO {

	private static final String SQL_SELECT_ALL = "SELECT * FROM client WHERE account_status=?";
	private static final String SQL_UPDATE_CLIENT = "UPDATE client SET deleted=? WHERE id=?";
	@Override
	public List<ClientDTO> getAll() {
		
		List<ClientDTO> clients = new ArrayList<ClientDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Object values[] = {true};
		try {
			connection = DBUtil.getConnection();
			preparedStatement = DBUtil.prepareStatement(connection, SQL_SELECT_ALL, false, values);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				clients.add(new ClientDTO(resultSet.getLong("id"),resultSet.getString("name"),resultSet.getString("surname"),
						resultSet.getString("username"),resultSet.getString("mail"),resultSet.getString("city"),
						resultSet.getBoolean("deleted")));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet,preparedStatement,connection);
		}
		return clients;
	}

	@Override
	public boolean blockUnblocClient(Long id, Boolean block) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Object[] values = {block, id};
		try {
			connection = DBUtil.getConnection();
			preparedStatement = DBUtil.prepareStatement(connection, SQL_UPDATE_CLIENT, true, values);
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
