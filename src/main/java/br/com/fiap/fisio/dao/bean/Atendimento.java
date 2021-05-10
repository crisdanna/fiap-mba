package br.com.fiap.fisio.dao.bean;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Atendimento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private LocalDate data;
	private LocalTime hora;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_profissional")
	private Profissional profissional;
	
	public Long getId() {
		return id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public Profissional getProfissional() {
		return profissional;
	}
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
}
