package br.com.fiap.fisio.service;

import java.util.List;

import br.com.fiap.fisio.dao.bean.Procedure;

public interface ProcedureService {
	void saveProcedure(Procedure procedure);
	Procedure getProcedure(Long id);
	void deleteProcedure(Procedure procedure);
	List<Procedure> getAllProcedures();
}
