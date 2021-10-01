package br.com.fiap.fisio.dto;

import java.util.List;

public class TreatmentDto {

	private Long id;
	
	private int authorizationNumber;
	
	private ProcedureDto procedure;
	private List<AppointmentDto> appointments;
	private PatientDto patient;
	
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
	public PatientDto getPatient() {
		return patient;
	}
	public void setPatient(PatientDto patient) {
		this.patient = patient;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**** TREATMENT DTO **** \n");
		sb.append("ID: ").append(this.getId()).append("\n");
		sb.append("Authorization Number: ").append(this.getAuthorizationNumber()).append("\n");
		sb.append(this.getPatient().toString()).append("\n");
		sb.append(this.getProcedure().toString()).append("\n");
				
		return sb.toString();
	}
}
