package br.com.fiap.fisio.dao.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Treatment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private int authorizationNumber;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "procedureId")
	private Procedure procedure;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Appointment> appointments;
	
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
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public Long getId() {
		return id;
	}
}
