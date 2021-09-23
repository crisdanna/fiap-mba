package br.com.fiap.fisio.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fisio.dao.bean.Professional;

@Repository
public interface ProfessionalRepository extends CrudRepository<Professional, Long> {
	public List<Professional> findByName(String name);
	public List<Professional> findByLastname(String lastname);
}
