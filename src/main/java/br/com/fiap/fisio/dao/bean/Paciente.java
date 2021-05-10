package br.com.fiap.fisio.dao.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Paciente extends Pessoa {

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Tratamento> tratamentos;

	public List<Tratamento> getTratamentos() {
		return tratamentos;
	}

	public void setTratamentos(List<Tratamento> tratamentos) {
		this.tratamentos = tratamentos;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**** PACIENTE **** \n");
		sb.append("ID: ").append(this.getId()).append("\n");
		sb.append("Nome: ").append(this.getNome()).append("\n");
		sb.append("Sobrenome: ").append(this.getSobrenome()).append("\n");
				
		return sb.toString();
	}
}
