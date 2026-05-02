package com.hospital.service;

import com.hospital.entity.Doctor;
import com.hospital.repository.DoctorRepository;
import com.hospital.exception.InvalidFeeException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Injecting EntityManager to explicitly use Hibernate/JPA for insertion as requested
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Doctor insertDoctor(Doctor doctor) {
        if (doctor.getFee() == null || doctor.getFee() <= 0) {
            throw new InvalidFeeException("Fee must be a valid positive amount.");
        }
        
        // Using EntityManager (Hibernate) explicitly to insert/persist the record
        entityManager.persist(doctor);
        
        // Note: We could also use doctorRepository.save(doctor) which internally does the same.
        return doctor;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<Doctor> getDoctorsWithHighFee(Double threshold) {
        return doctorRepository.findByFeeGreaterThan(threshold);
    }
}
