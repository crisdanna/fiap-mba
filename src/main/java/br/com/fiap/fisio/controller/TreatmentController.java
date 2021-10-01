package br.com.fiap.fisio.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fisio.dao.bean.Patient;
import br.com.fiap.fisio.dao.bean.Procedure;
import br.com.fiap.fisio.dao.bean.Treatment;
import br.com.fiap.fisio.dto.TreatmentDto;
import br.com.fiap.fisio.service.TreatmentService;

@RestController
@RequestMapping("treatment")
public class TreatmentController {
	@Autowired
	private TreatmentService service;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/list/{id}")
	public List<TreatmentDto> getTreatmentsByPatient(@PathVariable Long id){
		return convertToDtoList(service.getTreatmentsByPatient(id));
	}
	
	private List<TreatmentDto> convertToDtoList(List<Treatment> treatments) {
		List<TreatmentDto> treatmentDtoList = modelMapper.map(treatments, List.class);
	    return treatmentDtoList;
	}
	
	private TreatmentDto convertToDto(Treatment treatment) {
		TreatmentDto treatmentDto = modelMapper.map(treatment, TreatmentDto.class);
	    return treatmentDto;
	}
	
	public Treatment convertToEntity(TreatmentDto treatmentDto){
		Treatment treatment = modelMapper.map(treatmentDto, Treatment.class);
		treatment.setPatient(modelMapper.map(treatmentDto.getPatient(), Patient.class));
		treatment.setProcedure(modelMapper.map(treatmentDto.getProcedure(), Procedure.class));
		
	    return treatment;
	}
}
