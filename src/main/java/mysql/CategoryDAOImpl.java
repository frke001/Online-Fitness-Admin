package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDAO;
import dto.CategoryAttributeDTO;
import dto.CategoryDTO;
import dto.RequestAttributeDTO;
import dto.RequestCategoryDTO;
import util.DBUtil;

public class CategoryDAOImpl implements CategoryDAO {

	private static final String SQL_SELECT_ALL = "SELECT * FROM category WHERE deleted=?";
	private static final String SQL_SELECT_ALL_ATTRIBUTES = "SELECT * FROM category_attribute WHERE category_id=? AND deleted=?";
	private static final String SQL_INSERT_CATEGORY = "INSERT INTO category (name, deleted) VALUES (?,?)";
	private static final String SQL_DELETE_CATEGORY = "UPDATE category SET deleted=? WHERE id=?";
	private static final String SQL_UPDATE_CATEGORY = "UPDATE category SET name=? WHERE id=?";
	private static final String SQL_INSERT_CATEGORY_ATTRIBUTE = "INSERT INTO category_attribute (name, category_id, deleted) VALUES (?,?,?)";
	private static final String SQL_DELETE_ATTRIBUTE = "UPDATE category_attribute SET deleted=? WHERE id=?";
	@Override
	public List<CategoryDTO> getAll() {
		List<CategoryDTO> categories = new ArrayList<CategoryDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Object values[] = {false};
		try {
			connection = DBUtil.getConnection();
			preparedStatement = DBUtil.prepareStatement(connection, SQL_SELECT_ALL, false, values);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				categories.add(new CategoryDTO(resultSet.getLong("id"),resultSet.getString("name")));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet,preparedStatement,connection);
		}
		return categories;
	}
	@Override
	public List<CategoryAttributeDTO> getAllAttributesForCategory(long id) {
		List<CategoryAttributeDTO> attributes = new ArrayList<CategoryAttributeDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Object values[] = {id, false};
		try {
			connection = DBUtil.getConnection();
			preparedStatement = DBUtil.prepareStatement(connection, SQL_SELECT_ALL_ATTRIBUTES, false, values);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				attributes.add(new CategoryAttributeDTO(resultSet.getLong("id"),resultSet.getString("name")));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet,preparedStatement,connection);
		}
		return attributes;
	}
	@Override
	public boolean insertCategory(RequestCategoryDTO requestCategoryDTO) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Object[] values = {requestCategoryDTO.getName(), false};
		try {
			connection = DBUtil.getConnection();
			preparedStatement = DBUtil.prepareStatement(connection, SQL_INSERT_CATEGORY, true, values);
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
	public boolean deleteCategory(Long id) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Object[] values = {true,id};
		try {
			connection = DBUtil.getConnection();
			preparedStatement = DBUtil.prepareStatement(connection, SQL_DELETE_CATEGORY, true, values);
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
	public boolean modifyCategory(Long id, RequestCategoryDTO requestCategoryDTO) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Object[] values = {requestCategoryDTO.getName(), id};
		try {
			connection = DBUtil.getConnection();
			preparedStatement = DBUtil.prepareStatement(connection, SQL_UPDATE_CATEGORY, true, values);
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
	public boolean addAttributeForCategory(Long id, RequestAttributeDTO requestAttributeDTO) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Object[] values = {requestAttributeDTO.getName(), id, false};
		try {
			connection = DBUtil.getConnection();
			preparedStatement = DBUtil.prepareStatement(connection, SQL_INSERT_CATEGORY_ATTRIBUTE, true, values);
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
	public boolean deleteAttribute(Long id) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Object[] values = {true,id};
		try {
			connection = DBUtil.getConnection();
			preparedStatement = DBUtil.prepareStatement(connection, SQL_DELETE_ATTRIBUTE, true, values);
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
