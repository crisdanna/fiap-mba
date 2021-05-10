package br.com.fiap.fisio.dao.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Profissional extends Pessoa {

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Procedimento> especialidades;

	public List<Procedimento> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Procedimento> especialidades) {
		this.especialidades = especialidades;
	}
}
