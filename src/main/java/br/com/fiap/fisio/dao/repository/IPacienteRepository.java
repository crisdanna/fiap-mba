package br.com.fiap.fisio.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fisio.dao.bean.Paciente;

@Repository
public interface IPacienteRepository extends CrudRepository<Paciente, Long> {
	public List<Paciente> findByNome(String nome);
	public List<Paciente> findBySobrenome(String sobrenome);
}
