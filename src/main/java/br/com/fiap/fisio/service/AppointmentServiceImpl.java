package br.com.fiap.fisio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fisio.dao.bean.Appointment;
import br.com.fiap.fisio.dao.bean.Patient;
import br.com.fiap.fisio.dao.bean.Treatment;
import br.com.fiap.fisio.dao.repository.AppointmentRepository;
import br.com.fiap.fisio.dao.repository.PatientRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private AppointmentRepository repository;

	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public void saveAppointment(Appointment appointment) {
		this.repository.save(appointment);
	}

	@Override
	public Appointment getAppointment(Long id) {
		return this.repository.findById(id).get();
	}
	
	@Override
	public void deleteAppointment(Appointment appointment) {
		this.repository.delete(appointment);
	}

	@Override
	public List<Appointment> getAppointmentsByPatient(Long id) {
		Patient patient = this.patientRepository.findById(id).get();
		List<Treatment> treatments = patient.getTreatments();
		List<Appointment> appointments = new ArrayList<>();
		treatments.forEach(treatment -> appointments.addAll(treatment.getAppointments()));
		
		return appointments;
	}

	@Override
	public List<Appointment> getAppointmentsByProffessional(Long id) {
		return this.repository.findByProfessionalId(id);
	}

}
