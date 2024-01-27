package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import dao.AdminDAO;
import dto.AdminDTO;
import dto.LoginDTO;
import util.DBUtil;

public class AdminDAOImpl implements AdminDAO{

	private static final String SQL_SELECT_FOR_LOGIN = "SELECT * FROM admin WHERE username=?";
	@Override
	public AdminDTO login(LoginDTO loginDTO) {
		AdminDTO adminDTO = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Object values[] = {loginDTO.getUsername()};
		try {
			connection = DBUtil.getConnection();
			preparedStatement = DBUtil.prepareStatement(connection, SQL_SELECT_FOR_LOGIN, false, values);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				adminDTO = new AdminDTO(resultSet.getLong("id"), resultSet.getString("username"),
						resultSet.getString("password"),
						resultSet.getString("name"),
						resultSet.getString("surname"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(resultSet,preparedStatement,connection);
		}
		return adminDTO;
	}

}
