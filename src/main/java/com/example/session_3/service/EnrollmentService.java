package com.example.session_3.service;

import com.example.session_3.model.entity.Enrollment;
import com.example.session_3.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository  enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.create(enrollment);
    }

    public Enrollment updateEnrollment(Long id, Enrollment enrollment) {

        return enrollmentRepository.update(id, enrollment);
    }
    public Enrollment deleteEnrollment(Long id) {
        return enrollmentRepository.delete(id);
    }
}
