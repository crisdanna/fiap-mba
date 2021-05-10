package br.com.fiap.fisio.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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

import br.com.fiap.fisio.dao.bean.Atendimento;
import br.com.fiap.fisio.dao.bean.Endereco;
import br.com.fiap.fisio.dao.bean.Procedimento;
import br.com.fiap.fisio.dao.bean.Profissional;
import br.com.fiap.fisio.dao.bean.Tratamento;
import br.com.fiap.fisio.dao.repository.ITratamentoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestTratamentoRepository {

	@Autowired
	ITratamentoRepository repository;
	
	private Long idTratamento;
	
	@Before
	public void testeInsercao() {
		Atendimento atendimento = new Atendimento();
		atendimento.setData(LocalDate.parse("2021-05-21"));
		atendimento.setHora(LocalTime.of(15, 30));

		Profissional profissional = new Profissional();
		profissional.setNome("Jeff");
		profissional.setSobrenome("Dunham");
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua Trinca Ferro");
		endereco.setNumero(34);
		endereco.setBairro("Sumaré");
		endereco.setCidade("São Paulo");
		endereco.setEstado("SP");
		endereco.setCep("07865432");
		
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(endereco);
		
		profissional.setEnderecos(enderecos);
		
		Procedimento procedimento = new Procedimento();
		procedimento.setNome("Acupuntura");
		procedimento.setDescricao("Fisioterapia em Acupuntura");
		procedimento.setAutorizacaoM(false);
		
		List<Procedimento> procedimentos = new ArrayList<>();
		procedimentos.add(procedimento);
		
		profissional.setEspecialidades(procedimentos);
		
		atendimento.setProfissional(profissional);
		
		List<Atendimento> atendimentos = new ArrayList<>();
		atendimentos.add(atendimento);
		
		Tratamento tratamento = new Tratamento();
		tratamento.setNumeroAutorizacao(0);
		tratamento.setProcedimento(procedimento);
		tratamento.setAtendimentos(atendimentos);
		
		Tratamento tratamentoInserido = repository.save(tratamento);
		idTratamento = tratamentoInserido.getId();
	}
	
	@Test
	public void testeLeitura() {

		assertThat(repository.findAll())
				.flatExtracting(p -> List.of(p.getId()))
				.contains(idTratamento);
	}
	
	@Test
	public void testeAlteracao() {
		Optional<Tratamento> opt = repository.findById(idTratamento);
				
		Tratamento tratamento = opt.get();
		tratamento.setNumeroAutorizacao(123456);
		
		repository.save(tratamento);

		assertThat(repository.findAll())
				.flatExtracting(p -> List.of(p.getNumeroAutorizacao()))
				.contains(123456);
	}
	
	@Test
	public void testeRemocao() {
		Optional<Tratamento> tratamento = repository.findById(idTratamento);
		repository.delete(tratamento.get());
		
		assertThat(repository.findAll())
				.flatExtracting(p -> List.of(p.getId()))
				.doesNotContain(idTratamento);
	}
}
