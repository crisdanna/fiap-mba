package br.com.fiap.fisio.dao.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Procedimento {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	private String descricao;
	private boolean isAutorizacaoM;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isAutorizacaoM() {
		return isAutorizacaoM;
	}
	public void setAutorizacaoM(boolean isAutorizacaoM) {
		this.isAutorizacaoM = isAutorizacaoM;
	}
}
