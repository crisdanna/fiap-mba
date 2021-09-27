package br.com.fiap.fisio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fisio.dao.bean.Procedure;
import br.com.fiap.fisio.dao.repository.ProcedureRepository;

@Service
public class ProcedureServiceImpl implements ProcedureService {
	@Autowired
	private ProcedureRepository repository;

	@Override
	public void saveProcedure(Procedure procedure) {
		this.saveProcedure(procedure);
	}

	@Override
	public Procedure getProcedure(Long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public void deleteProcedure(Procedure procedure) {
		this.repository.delete(procedure);
	}

	@Override
	public List<Procedure> getAllProcedures() {
		return (List<Procedure>) this.repository.findAll();
	}

}
