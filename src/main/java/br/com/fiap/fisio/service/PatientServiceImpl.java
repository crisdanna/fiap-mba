package br.com.fiap.fisio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fisio.dao.bean.Patient;
import br.com.fiap.fisio.dao.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository repository;

	@Override
	public void savePatient(Patient patient) {
		this.repository.save(patient);
	}

	@Override
	public Patient getPatient(Long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public void deletePatient(Patient patient) {
		this.repository.delete(patient);
	}

	@Override
	public List<Patient> getAllPatients() {
		return (List<Patient>) this.repository.findAll();
	}

}
