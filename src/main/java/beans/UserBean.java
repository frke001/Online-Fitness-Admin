package beans;

import java.io.Serializable;
import java.util.List;

import dao.AdvisorDAO;
import dao.ClientDAO;
import dto.AdvisorDTO;
import dto.ClientDTO;
import dto.RequestAdvisorDTO;
import mysql.AdvisorDAOImpl;
import mysql.ClientDAOImpl;

public class UserBean implements Serializable {

	private static final long serialVersionUID = -2295422945986092939L;
	private ClientDAO clientDAO = new ClientDAOImpl();
	private AdvisorDAO advisorDAO = new AdvisorDAOImpl();
	
	public List<ClientDTO> getAllClients(){
		return clientDAO.getAll();
	}
	public boolean blockUnblockClient(Long id, Boolean block){
		return clientDAO.blockUnblocClient(id, block);
	}
	public List<AdvisorDTO> getAllAdvisors(){
		return advisorDAO.getAll();
	}
	public boolean blockUnblocAdvisor(Long id, Boolean block){
		return advisorDAO.blockUnblocAdvisor(id, block);
	}
	public boolean insertAdvisor(RequestAdvisorDTO requestAdvisorDTO) {
		return advisorDAO.insert(requestAdvisorDTO);
	}

}
