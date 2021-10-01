package br.com.fiap.fisio.dao.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "treatment")
public class Treatment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "treatment_id_seq")
	@SequenceGenerator(name = "treatment_id_seq", allocationSize = 1)
	private Long id;
	
	private int authorizationNumber;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "procedureId")
	private Procedure procedure;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Patient patient;
	
	public int getAuthorizationNumber() {
		return authorizationNumber;
	}
	public void setAuthorizationNumber(int authorizationNumber) {
		this.authorizationNumber = authorizationNumber;
	}
	public Procedure getProcedure() {
		return procedure;
	}
	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**** TREATMENT **** \n");
		sb.append("ID: ").append(this.getId()).append("\n");
		sb.append("Authorization Number: ").append(this.getAuthorizationNumber()).append("\n");
		sb.append(this.getPatient().toString()).append("\n");
		sb.append(this.getProcedure().toString()).append("\n");
				
		return sb.toString();
	}
}
