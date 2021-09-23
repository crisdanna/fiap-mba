package br.com.fiap.fisio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.fisio.dao.bean.Professional;
import br.com.fiap.fisio.dao.repository.ProfessionalRepository;

public class ProfessioanlServiceImpl implements ProfessionalService {
	
	@Autowired
	private ProfessionalRepository repository;

	@Override
	public void saveProfessional(Professional professional) {
		this.repository.save(professional);
	}

	@Override
	public Professional getProfessional(Long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public void deleteProfessional(Professional professional) {
		this.repository.delete(professional);
	}

	@Override
	public List<Professional> getAllProfessionals() {
		return (List<Professional>) this.repository.findAll();
	}

}
