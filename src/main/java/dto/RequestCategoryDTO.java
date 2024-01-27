package dto;

import java.io.Serializable;

public class RequestCategoryDTO implements Serializable{

	private static final long serialVersionUID = -648532591787083679L;
	private String name;
	public RequestCategoryDTO() {

	}
	public RequestCategoryDTO(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
