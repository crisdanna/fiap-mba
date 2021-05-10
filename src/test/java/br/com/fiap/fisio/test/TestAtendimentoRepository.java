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
import br.com.fiap.fisio.dao.repository.IAtendimentoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestAtendimentoRepository {

	@Autowired
	IAtendimentoRepository repository;
	
	private Long idAtendimento;
	
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
		
		Atendimento atendimentoInserido = repository.save(atendimento);
		idAtendimento = atendimentoInserido.getId();
	}
	
	@Test
	public void testeLeitura() {

		assertThat(repository.findAll())
				.flatExtracting(p -> List.of(p.getData().getDayOfMonth()))
				.contains(21);
	}
	
	@Test
	public void testeAlteracao() {
		Optional<Atendimento> opt = repository.findById(idAtendimento);
				
		Atendimento atendimento = opt.get();
		atendimento.setData(LocalDate.parse("2021-05-23"));
		
		repository.save(atendimento);

		assertThat(repository.findAll())
				.flatExtracting(p -> List.of(p.getData().getDayOfMonth()))
				.contains(23);
	}
	
	@Test
	public void testeRemocao() {
		Optional<Atendimento> atendimento = repository.findById(idAtendimento);
		repository.delete(atendimento.get());
		
		assertThat(repository.findAll())
				.flatExtracting(p -> List.of(p.getId()))
				.doesNotContain(idAtendimento);
	}
}
