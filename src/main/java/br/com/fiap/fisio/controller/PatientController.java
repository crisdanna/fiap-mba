package br.com.fiap.fisio.controller;

import javax.websocket.server.PathParam;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fisio.dao.bean.Patient;
import br.com.fiap.fisio.dto.PatientDto;
import br.com.fiap.fisio.service.PatientService;

@RestController
@RequestMapping("patient")
public class PatientController {

	@Autowired
	private PatientService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public void savePatient(@RequestBody PatientDto patient) {
		this.service.savePatient(convertToEntity(patient));
	}
	
	@GetMapping("/{id}")
	public PatientDto getPatient(@PathParam(value = "id") Long id) {
		return convertToDto(this.service.getPatient(id));
	}
		
	private PatientDto convertToDto(Patient post) {
	    PatientDto patientDto = modelMapper.map(post, PatientDto.class);
	    return patientDto;
	}
	
	private Patient convertToEntity(PatientDto patientDto){
	    Patient patient = modelMapper.map(patientDto, Patient.class);
	    return patient;
	}
}
