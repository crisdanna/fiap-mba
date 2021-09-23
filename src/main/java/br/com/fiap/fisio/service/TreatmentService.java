package br.com.fiap.fisio.service;

import java.util.List;

import br.com.fiap.fisio.dao.bean.Treatment;

public interface TreatmentService {
	void saveTreatment(Treatment treatment);
	Treatment getTreatment(Long id);
	void deleteTreatment(Treatment treatment);
	List<Treatment> getTreatmentsByPatient(Long id);
}
