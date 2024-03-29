package dto;

import java.io.Serializable;

public class AdvisorDTO implements Serializable{

	private static final long serialVersionUID = 2797974217277099745L;
	private Long id;
	private String name;
	private String surname;
	private String username;
	private String mail;
	private Boolean deleted;
	public AdvisorDTO() {
	}
	public AdvisorDTO(Long id, String name, String surname, String username, String mail, Boolean deleted) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.mail = mail;
		this.deleted = deleted;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}
