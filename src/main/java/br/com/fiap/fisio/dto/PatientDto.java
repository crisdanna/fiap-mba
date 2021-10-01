package br.com.fiap.fisio.dto;

import java.util.List;

public class PatientDto extends PersonDto{

	private List<TreatmentDto> treatments;

	public List<TreatmentDto> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<TreatmentDto> treatments) {
		this.treatments = treatments;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**** PATIENT DTO **** \n");
		sb.append("ID: ").append(this.getId()).append("\n");
		sb.append("Name: ").append(this.getName()).append("\n");
		sb.append("Last Name: ").append(this.getLastname()).append("\n");
				
		return sb.toString();
	}
}
