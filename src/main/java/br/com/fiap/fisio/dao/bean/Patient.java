package br.com.fiap.fisio.dao.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Patient extends Person {
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**** PATIENT **** \n");
		sb.append("ID: ").append(this.getId()).append("\n");
		sb.append("Name: ").append(this.getName()).append("\n");
		sb.append("Last Name: ").append(this.getLastname()).append("\n");
				
		return sb.toString();
	}
}
