package br.com.fiap.fisio.service;

import java.util.List;

import br.com.fiap.fisio.dao.bean.Professional;

public interface ProfessionalService {
	void saveProfessional(Professional professional);
	Professional getProfessional(Long id);
	void deleteProfessional(Professional professional);
	List<Professional> getAllProfessionals();
}
