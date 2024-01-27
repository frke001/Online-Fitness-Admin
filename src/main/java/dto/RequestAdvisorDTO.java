package dto;

import java.io.Serializable;

public class RequestAdvisorDTO implements Serializable {

	private static final long serialVersionUID = -4524068411959273291L;
	private String name;
	private String surname;
	private String username;
	private String password;
	private String mail;
	public RequestAdvisorDTO() {
	}
	public RequestAdvisorDTO(String name, String surname, String username,String password, String mail) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.mail = mail;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
