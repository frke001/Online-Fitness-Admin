package dao;

import java.util.List;

import dto.LogDTO;
import dto.LoginDTO;

public interface LogDAO {
	
	List<LogDTO> getLogsByPage(int pageSize, int pageNumber);
	Integer getTotalPages(int pageSize);

}
