package br.com.fiap.fisio.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.fisio.dao.bean.Procedimento;
import br.com.fiap.fisio.dao.repository.IProcedimentoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestProcedimentoRepository {

	@Autowired
	IProcedimentoRepository repository;
	
	private Long idProcedimento;
	
	@Before
	public void testeInsercao() {

		Procedimento procedimento = new Procedimento();
		procedimento.setNome("Acupuntura");
		procedimento.setDescricao("Fisioterapia em Acupuntura");
		procedimento.setAutorizacaoM(false);
		
		Procedimento procedimentoInserido = repository.save(procedimento);
		idProcedimento = procedimentoInserido.getId();
	}
	
	@Test
	public void testeLeitura() {

		assertThat(repository.findAll())
				.flatExtracting(p -> List.of(p.getNome()))
				.contains("Acupuntura");
	}
	
	@Test
	public void testeAlteracao() {
		Optional<Procedimento> procedimentoOpt = repository.findById(idProcedimento);
				
		Procedimento procedimento = procedimentoOpt.get();
		procedimento.setDescricao("Fisioterapia em Acupuntura Moderna");
		
		repository.save(procedimento);

		assertThat(repository.findAll())
				.flatExtracting(p -> List.of(p.getDescricao()))
				.contains("Fisioterapia em Acupuntura Moderna");
	}
	
	@Test
	public void testeRemocao() {
		Optional<Procedimento> procedimento = repository.findById(idProcedimento);
		repository.delete(procedimento.get());
		
		assertThat(repository.findAll())
				.flatExtracting(p -> List.of(p.getNome()))
				.doesNotContain("Acupuntura");
	}
}
