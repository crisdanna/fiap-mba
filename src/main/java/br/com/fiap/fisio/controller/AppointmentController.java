package br.com.fiap.fisio.controller;

import javax.websocket.server.PathParam;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fisio.dao.bean.Appointment;
import br.com.fiap.fisio.dto.AppointmentDto;
import br.com.fiap.fisio.service.AppointmentService;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
	@Autowired
	private AppointmentService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public void saveAppointment(@RequestBody AppointmentDto appointment) {
		this.service.saveAppointment(convertToEntity(appointment));
	}
	
	@GetMapping("/{id}")
	public AppointmentDto getAppointment(@PathParam(value = "id") Long id) {
		return convertToDto(this.service.getAppointment(id));
	}
	
	@DeleteMapping("/{id}")
	public void deleteAppointment(@PathParam(value = "id") Long id) {
		this.service.deleteAppointment(this.service.getAppointment(id));
	}
	
	private AppointmentDto convertToDto(Appointment appointment) {
		AppointmentDto appointmentDto = modelMapper.map(appointment, AppointmentDto.class);
	    return appointmentDto;
	}
	
	private Appointment convertToEntity(AppointmentDto appointmentDto){
		Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);
	    return appointment;
	}
}
