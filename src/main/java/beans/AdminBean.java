package beans;

import java.io.Serializable;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dao.AdminDAO;
import dto.AdminDTO;
import dto.LoginDTO;
import mysql.AdminDAOImpl;

public class AdminBean implements Serializable{

	private static final long serialVersionUID = 1706073343156910093L;
	private AdminDTO adminDTO = new AdminDTO();
	private boolean isLoggedIn = false;
	private AdminDAO adminDAO = new AdminDAOImpl();
	
	public boolean login(LoginDTO loginDTO) {
		adminDTO =  adminDAO.login(loginDTO);
		if (adminDTO == null) {
			isLoggedIn = false;
			return false;
	    }
	    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
	    if (encoder.matches(loginDTO.getPassword(), adminDTO.getPassword())) {
	    	isLoggedIn = true;
	    	return true;
	    }
	    else {
	    	isLoggedIn = false;
	    	return false;
	    }
	}
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	

}
