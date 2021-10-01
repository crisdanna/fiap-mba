package br.com.fiap.fisio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.fisio.dao.bean.Appointment;
import br.com.fiap.fisio.dao.bean.Patient;
import br.com.fiap.fisio.dao.bean.Procedure;
import br.com.fiap.fisio.dao.bean.Treatment;
import br.com.fiap.fisio.dao.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	private static transient Logger logger = LoggerFactory.getLogger(AppointmentServiceImpl.class);
	
	@Autowired
	private AppointmentRepository repository;

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private ProcedureService procedureService;
	
	@Autowired
	private TreatmentService treatmentService;
	
	@Autowired
	private ProfessionalService professionalService;
	
	@Override
	@Transactional
	public void saveAppointment(Appointment appointment) {
		
		Treatment treatment = null;
		try{
			List<Treatment> treatments = this.treatmentService.getTreatmentsByPatient(appointment.getTreatment().getPatient().getId());
			
			Stream<Treatment> existingTreatment = treatments.stream()
				.filter(t -> t.getProcedure().getId() == appointment.getTreatment().getProcedure().getId());
			treatment = existingTreatment.findFirst().get();
		}catch (Exception e) {
			logger.warn("No treatment found for patient and procedure.");
		}
		
		if(treatment == null) {
			treatment = appointment.getTreatment();
			Patient patient = this.patientService.getPatient(treatment.getPatient().getId());
			treatment.setPatient(patient);
			
			Procedure procedure = this.procedureService.getProcedure(treatment.getProcedure().getId());
			treatment.setProcedure(procedure);
			
			this.treatmentService.saveTreatment(treatment);
		}
		
		appointment.setTreatment(treatment);
		appointment.setProfessional(this.professionalService.getProfessional(appointment.getProfessional().getId()));
				
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
		Patient patient = this.patientService.getPatient(id);
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
