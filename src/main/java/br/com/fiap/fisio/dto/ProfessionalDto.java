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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**** PROFESSIONAL DTO **** \n");
		sb.append("ID: ").append(this.getId()).append("\n");
		sb.append("Name: ").append(this.getName()).append("\n");
		sb.append("Last Name: ").append(this.getLastname()).append("\n");
		sb.append("Phone: ").append(this.getPhone()).append("\n");
		
		return sb.toString();
	}
}
