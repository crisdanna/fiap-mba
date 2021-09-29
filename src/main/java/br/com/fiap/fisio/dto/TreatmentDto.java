package br.com.fiap.fisio.dto;

import java.util.List;

public class TreatmentDto {

	private Long id;
	
	private int authorizationNumber;
	
	private ProcedureDto procedure;
	private List<AppointmentDto> appointments;
	
	public int getAuthorizationNumber() {
		return authorizationNumber;
	}
	public void setAuthorizationNumber(int authorizationNumber) {
		this.authorizationNumber = authorizationNumber;
	}
	public ProcedureDto getProcedure() {
		return procedure;
	}
	public void setProcedure(ProcedureDto procedure) {
		this.procedure = procedure;
	}
	public List<AppointmentDto> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<AppointmentDto> appointments) {
		this.appointments = appointments;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
