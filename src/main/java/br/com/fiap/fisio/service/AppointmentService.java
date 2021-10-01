package br.com.fiap.fisio.service;

import java.util.List;

import br.com.fiap.fisio.dao.bean.Appointment;

public interface AppointmentService {
	Appointment saveAppointment(Appointment appointment);
	Appointment getAppointment(Long id);
	void deleteAppointment(Appointment appointment);
	List<Appointment> getAppointmentsByPatient(Long id);
	List<Appointment> getAppointmentsByProffessional(Long id);
}
