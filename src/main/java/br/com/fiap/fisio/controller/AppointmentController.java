package br.com.fiap.fisio.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fisio.dao.bean.Appointment;
import br.com.fiap.fisio.dao.bean.Professional;
import br.com.fiap.fisio.dto.AppointmentDto;
import br.com.fiap.fisio.service.AppointmentService;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
	private static transient Logger logger = LoggerFactory.getLogger(AppointmentController.class);
	
	@Autowired
	private AppointmentService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private TreatmentController treatmentController;
	
	@Autowired
	private ProfessionalController professionalController;
	
	@PostMapping
	public Appointment saveAppointment(@RequestBody AppointmentDto appointment) {
		return this.service.saveAppointment(convertToEntity(appointment));
	}
	
	@GetMapping("/{id}")
	public AppointmentDto getAppointment(@PathVariable("id") Long id) {
		return convertToDto(this.service.getAppointment(id));
	}
	
	@GetMapping("/list/{id}")
	public List<AppointmentDto> getAppointmentsByPatient(@PathVariable("id") Long id) {
		return convertToDtoList(this.service.getAppointmentsByPatient(id));
	}
	
	@DeleteMapping("/{id}")
	public String deleteAppointment(@PathVariable("id") Long id) {
		try {
			this.service.deleteAppointment(this.service.getAppointment(id));
		}catch(Exception e) {
			logger.error("Unable to delete appointment.", e);
		}
		return "Appointment deleted.";
	}
	
	private AppointmentDto convertToDto(Appointment appointment) {
		AppointmentDto appointmentDto = modelMapper.map(appointment, AppointmentDto.class);
		appointmentDto.setProfessional(this.professionalController.convertToDto(appointment.getProfessional()));
		appointmentDto.setTreatment(this.treatmentController.convertToDto(appointment.getTreatment()));
		appointmentDto.setDate(appointment.getDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
		
	    return appointmentDto;
	}
	
	private List<AppointmentDto> convertToDtoList(List<Appointment> appointments) {
		logger.info("Appointments to convert: {}", appointments.size());
		List<AppointmentDto> appointmentsList = new ArrayList<AppointmentDto>();
		appointments.forEach(appointment -> {
			appointmentsList.add(convertToDto(appointment));
		});
		
		return appointmentsList;
	}
	
	private Appointment convertToEntity(AppointmentDto appointmentDto){
		Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);
		appointment.setDate(LocalDate.parse(appointmentDto.getDate(), DateTimeFormatter.ofPattern("MM/dd/yyyy")));
		appointment.setTime(LocalTime.parse(appointmentDto.getTime(), DateTimeFormatter.ofPattern("HH:mm")));
		
		appointment.setProfessional(modelMapper.map(appointmentDto.getProfessional(), Professional.class));
		appointment.setTreatment(this.treatmentController.convertToEntity(appointmentDto.getTreatment()));
		
		return appointment;
	}
}
