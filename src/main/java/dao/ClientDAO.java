package dao;

import java.util.List;

import dto.ClientDTO;

public interface ClientDAO {
	List<ClientDTO> getAll();
	boolean blockUnblocClient(Long id, Boolean block);
}
