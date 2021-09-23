package br.com.fiap.fisio.dto;

import java.util.ArrayList;
import java.util.List;

public class PersonDto {

	private Long id;
	
	private String name;
	private String lastname;
    private List<AddressDto> addresses = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public List<AddressDto> getAddress() {
		return addresses;
	}
	public void setAddresss(List<AddressDto> addresses) {
		this.addresses = addresses;
	}
}
