package br.com.fiap.fisio.test;

import static org.assertj.core.api.Assertions.assertThat;

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

import br.com.fiap.fisio.dao.bean.Endereco;
import br.com.fiap.fisio.dao.bean.Procedimento;
import br.com.fiap.fisio.dao.bean.Profissional;
import br.com.fiap.fisio.dao.repository.IProfissionalRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestProfissionalRepository {

	@Autowired
	IProfissionalRepository repository;
	
	private Long idProfissional;
	
	@Before
	public void testeInsercao() {

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
		
		Profissional profissionalInserido = repository.save(profissional);
		idProfissional = profissionalInserido.getId();
	}
	
	@Test
	public void testeLeitura() {

		assertThat(repository.findAll())
				.flatExtracting(p -> List.of(p.getNome()))
				.contains("Jeff");
	}
	
	@Test
	public void testeAlteracao() {
		Optional<Profissional> profissionalOpt = repository.findById(idProfissional);
				
		Profissional profissional = profissionalOpt.get();
		profissional.setSobrenome("Smith");
		
		Procedimento procedimento = new Procedimento();
		procedimento.setNome("Esportiva");
		procedimento.setDescricao("Fisioterapia Esportiva");
		procedimento.setAutorizacaoM(true);
		
		profissional.getEspecialidades().add(procedimento);
			
		repository.save(profissional);

		assertThat(repository.findAll())
				.flatExtracting(p -> List.of(p.getSobrenome()))
				.contains("Smith");
	}
	
	@Test
	public void testeRemocao() {
		Optional<Profissional> profissional = repository.findById(idProfissional);
		repository.delete(profissional.get());
		
		assertThat(repository.findAll())
				.flatExtracting(p -> List.of(p.getNome()))
				.doesNotContain("Jeff");
	}
}
