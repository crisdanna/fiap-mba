package br.com.fiap.fisio.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fisio.dao.bean.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
	public List<Patient> findByName(String name);
	public List<Patient> findByLastname(String lastname);
	public List<Patient> findByEmail(String email);
}
