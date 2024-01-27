package dto;

import java.io.Serializable;
import java.util.Date;

public class LogDTO implements Serializable{

	private static final long serialVersionUID = 4393560792399032639L;
	private Long id;
	private String level;
	private String message;
	private Date creationDate;
	public LogDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LogDTO(Long id, String level, String message, Date creationDate) {
		super();
		this.id = id;
		this.level = level;
		this.message = message;
		this.creationDate = creationDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	

}
