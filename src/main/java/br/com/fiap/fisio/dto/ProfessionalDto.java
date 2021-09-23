package br.com.fiap.fisio.dto;

import java.util.List;

public class ProfessionalDto extends PersonDto{
	private List<ProcedureDto> specialties;

	public List<ProcedureDto> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(List<ProcedureDto> specialties) {
		this.specialties = specialties;
	}
}
