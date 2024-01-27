package dto;

import java.io.Serializable;

public class AdminDTO implements Serializable{
	private static final long serialVersionUID = 2470964683633564672L;
	private Long id;
	private String username;
	private String password;
	private String name;
	private String surname;
	
	public AdminDTO() {

	}
	public AdminDTO(Long id, String username, String password, String name, String surname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", surname=" + surname + "]";
	}
	
}
