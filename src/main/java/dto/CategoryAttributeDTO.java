package dto;

import java.io.Serializable;

public class CategoryAttributeDTO implements Serializable{

	private static final long serialVersionUID = -8824261679822645364L;
	private Long id;
	private String name;
	public CategoryAttributeDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public CategoryAttributeDTO() {
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
	
	

}
