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
import br.com.fiap.fisio.dao.bean.Paciente;
import br.com.fiap.fisio.dao.repository.IPacienteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestPacienteRepository {

	@Autowired
	IPacienteRepository repository;
	
	private Long idPaciente;
	
	@Before
	public void testeInsercao() {

		Paciente paciente = new Paciente();
		paciente.setNome("Chloe");
		paciente.setSobrenome("O'Brian");
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Av Brasil");
		endereco.setNumero(234);
		endereco.setBairro("Perdizes");
		endereco.setCidade("São Paulo");
		endereco.setEstado("SP");
		endereco.setCep("05028140");
		
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(endereco);
		
		paciente.setEnderecos(enderecos);
		
		Paciente pacienteInserido = repository.save(paciente);
		idPaciente = pacienteInserido.getId();
	}
	
	@Test
	public void testeLeitura() {

		assertThat(repository.findAll())
				.flatExtracting(p -> List.of(p.getNome()))
				.contains("Chloe");
	}
	
	@Test
	public void testeAlteracao() {
		Optional<Paciente> pacienteOpt = repository.findById(idPaciente);
				
		Paciente paciente = pacienteOpt.get();
		System.out.println(paciente);
		paciente.setSobrenome("Micallef");
			
		repository.save(paciente);

		assertThat(repository.findAll())
				.flatExtracting(p -> List.of(p.getSobrenome()))
				.contains("Micallef");
	}
	
	@Test
	public void testeRemocao() {
		Optional<Paciente> paciente = repository.findById(idPaciente);
		repository.delete(paciente.get());
		
		assertThat(repository.findAll())
				.flatExtracting(p -> List.of(p.getNome()))
				.doesNotContain("Chloe");
	}
}
