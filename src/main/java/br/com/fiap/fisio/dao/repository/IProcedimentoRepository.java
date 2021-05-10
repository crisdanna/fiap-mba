package br.com.fiap.fisio.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fisio.dao.bean.Procedimento;

@Repository
public interface IProcedimentoRepository extends CrudRepository<Procedimento, Long> {
	public List<Procedimento> findByNome(String nome);
}
