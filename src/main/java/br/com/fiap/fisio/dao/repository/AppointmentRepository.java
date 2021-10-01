package br.com.fiap.fisio.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fisio.dao.bean.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
	
	@Query("select a from Appointment a where a.professional.id = ?1")
	List<Appointment> findByProfessionalId(Long id);
	
	@Query("select a from Appointment a, Treatment t where a.treatment.id = t.id and t.patient.id = ?1")
	List<Appointment> findByPatientId(Long id);
}
