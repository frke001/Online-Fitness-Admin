package dto;

import java.io.Serializable;

public class RequestAttributeDTO implements Serializable {

	private static final long serialVersionUID = -679507686577837569L;
	
	private String name;
	public RequestAttributeDTO() {

	}
	public RequestAttributeDTO(String name) {
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
