package br.com.fiap.fisio.dao.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "procedure")
public class Procedure {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "procedure_id_seq")
	@SequenceGenerator(name = "procedure_id_seq", allocationSize = 1)
	private Long id;
	private String name;
	private String decription;
	private boolean isAuthorizationM;
	
	public void setId(Long id) {
		this.id = id;
	}
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**** PROCEDURE **** \n");
		sb.append("ID: ").append(this.getId()).append("\n");
		sb.append("Name: ").append(this.getName()).append("\n");
		sb.append("Description: ").append(this.getDecription()).append("\n");
		sb.append("Is authorization Mandatory: ").append(this.isAuthorizationM()).append("\n");
				
		return sb.toString();
	}
}
