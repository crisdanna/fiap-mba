package br.com.fiap.fisio.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fisio.dao.bean.Tratamento;

@Repository
public interface ITratamentoRepository extends CrudRepository<Tratamento, Long> {

}
