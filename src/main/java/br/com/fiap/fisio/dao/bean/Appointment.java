package br.com.fiap.fisio.dao.bean;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "appointment_id_seq")
	@SequenceGenerator(name = "appointment_id_seq", allocationSize = 1)
	private Long id;
	
	private LocalDate date;
	private LocalTime time;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "professionalId")
	private Professional professional;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Treatment treatment;
	
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
	public Professional getProfessional() {
		return professional;
	}
	public void setProfessional(Professional professional) {
		this.professional = professional;
	}
	public Treatment getTreatment() {
		return treatment;
	}
	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}
	
}
