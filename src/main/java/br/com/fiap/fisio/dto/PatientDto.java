package br.com.fiap.fisio.dto;

public class PatientDto extends PersonDto{
	
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
