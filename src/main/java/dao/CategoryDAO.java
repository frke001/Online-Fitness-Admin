package dao;

import java.util.List;

import dto.CategoryAttributeDTO;
import dto.CategoryDTO;
import dto.RequestAttributeDTO;
import dto.RequestCategoryDTO;

public interface CategoryDAO {
	
	List<CategoryDTO> getAll();
	List<CategoryAttributeDTO> getAllAttributesForCategory(long id);
	boolean insertCategory(RequestCategoryDTO requestCategoryDTO);
	boolean deleteCategory(Long id);
	boolean modifyCategory(Long id,RequestCategoryDTO requestCategoryDTO);
	boolean addAttributeForCategory(Long id, RequestAttributeDTO requestAttributeDTO);
	boolean deleteAttribute(Long id);

}
