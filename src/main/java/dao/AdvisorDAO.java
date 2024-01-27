package dao;

import java.util.List;

import dto.AdvisorDTO;
import dto.RequestAdvisorDTO;

public interface AdvisorDAO {
	
	List<AdvisorDTO> getAll();
	boolean blockUnblocAdvisor(Long id, Boolean block);
	boolean insert(RequestAdvisorDTO requestAdvisorDTO);

}
