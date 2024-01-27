package dao;

import dto.AdminDTO;
import dto.LoginDTO;

public interface AdminDAO {

	AdminDTO login(LoginDTO loginDTO);
}
