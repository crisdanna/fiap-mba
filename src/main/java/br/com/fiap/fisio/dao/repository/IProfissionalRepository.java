package br.com.fiap.fisio.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fisio.dao.bean.Profissional;

@Repository
public interface IProfissionalRepository extends CrudRepository<Profissional, Long> {
	public List<Profissional> findByNome(String nome);
	public List<Profissional> findBySobrenome(String sobrenome);
}
