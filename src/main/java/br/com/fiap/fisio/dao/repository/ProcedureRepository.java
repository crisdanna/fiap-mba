package br.com.fiap.fisio.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fisio.dao.bean.Procedure;

@Repository
public interface ProcedureRepository extends CrudRepository<Procedure, Long> {
	public List<Procedure> findByName(String name);
}
