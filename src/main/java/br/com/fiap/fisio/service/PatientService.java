package br.com.fiap.fisio.service;

import java.util.List;

import br.com.fiap.fisio.dao.bean.Patient;

public interface PatientService {
	void savePatient(Patient patient);
	Patient getPatient(Long id);
	void deletePatient(Patient patient);
	List<Patient> getAllPatients();
}
