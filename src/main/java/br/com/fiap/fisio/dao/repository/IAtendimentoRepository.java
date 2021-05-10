package br.com.fiap.fisio.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fisio.dao.bean.Atendimento;

@Repository
public interface IAtendimentoRepository extends CrudRepository<Atendimento, Long> {

}
