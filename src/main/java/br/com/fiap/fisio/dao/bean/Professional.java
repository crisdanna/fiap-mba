package br.com.fiap.fisio.dao.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Professional extends Person {

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Procedure> specialties;

	public List<Procedure> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(List<Procedure> specialties) {
		this.specialties = specialties;
	}
}
