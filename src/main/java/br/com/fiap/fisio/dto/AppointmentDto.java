package br.com.fiap.fisio.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDto {

	private Long id;
	
	private LocalDate date;
	private LocalTime time;
	private ProfessionalDto professional;
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public ProfessionalDto getProfessional() {
		return professional;
	}
	public void setProfessional(ProfessionalDto professional) {
		this.professional = professional;
	}
}
