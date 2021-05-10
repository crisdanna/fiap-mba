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
public class Tratamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private int numeroAutorizacao;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_procedimento")
	private Procedimento procedimento;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Atendimento> atendimentos;
	
	public int getNumeroAutorizacao() {
		return numeroAutorizacao;
	}
	public void setNumeroAutorizacao(int numeroAutorizacao) {
		this.numeroAutorizacao = numeroAutorizacao;
	}
	public Procedimento getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}
	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}
	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}
	public Long getId() {
		return id;
	}
}
