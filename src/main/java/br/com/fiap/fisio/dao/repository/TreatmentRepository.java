package br.com.fiap.fisio.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fisio.dao.bean.Treatment;

@Repository
public interface TreatmentRepository extends CrudRepository<Treatment, Long> {

	List<Treatment> findByPatientId(Long id);
}
