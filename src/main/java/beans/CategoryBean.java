package beans;

import java.io.Serializable;
import java.util.List;

import dao.CategoryDAO;
import dto.CategoryAttributeDTO;
import dto.CategoryDTO;
import dto.RequestAttributeDTO;
import dto.RequestCategoryDTO;
import mysql.CategoryDAOImpl;

public class CategoryBean implements Serializable{

	private static final long serialVersionUID = 2234838546106808147L;
	private CategoryDAO categoryDAO = new CategoryDAOImpl();
	
	public List<CategoryDTO> getAll(){
		return categoryDAO.getAll();
	}
	public List<CategoryAttributeDTO> getAllAttributesForCategory(Long id){
		return categoryDAO.getAllAttributesForCategory(id);
	}
	public boolean insertCategory(RequestCategoryDTO requestCategoryDTO) {
		return categoryDAO.insertCategory(requestCategoryDTO);
	}
	public boolean deleteCategory(Long id) {
		boolean result = false;
		result = categoryDAO.deleteCategory(id);
		for(var attr : this.getAllAttributesForCategory(id)) {
			result = this.deleteAttribute(attr.getId());
		}
		return result;
	}
	public boolean updateCategory(Long id, RequestCategoryDTO requestCategoryDTO) {
		return categoryDAO.modifyCategory(id,requestCategoryDTO);
	}
	public boolean addAttributeForCategory(Long id, RequestAttributeDTO requestAttributeDTO) {
		return categoryDAO.addAttributeForCategory(id, requestAttributeDTO);
	}
	public boolean deleteAttribute(Long id) {
		return categoryDAO.deleteAttribute(id);
	}

}
