package br.com.fiap.fisio.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fisio.dao.bean.Professional;
import br.com.fiap.fisio.dto.ProfessionalDto;
import br.com.fiap.fisio.service.ProfessionalService;

@RestController
@RequestMapping("professional")
public class ProfessionalController {
	@Autowired
	private ProfessionalService service;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/list")
	public List<ProfessionalDto> getProfessionals(){
		return convertToDtoList(service.getAllProfessionals());
	}
	
	private List<ProfessionalDto> convertToDtoList(List<Professional> professionals) {
		List<ProfessionalDto> professionalDtoList = modelMapper.map(professionals, List.class);
	    return professionalDtoList;
	}
}
