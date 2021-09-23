package br.com.fiap.fisio.dto;

public class ProcedureDto {

	private Long id;
	private String name;
	private String decription;
	private boolean isAuthorizationM;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public boolean isAuthorizationM() {
		return isAuthorizationM;
	}
	public void setAuthorizationM(boolean isAuthorizationM) {
		this.isAuthorizationM = isAuthorizationM;
	}
}
