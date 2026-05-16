package com.example.session_3.controller;

import com.example.session_3.model.dto.ApiResponse;
import com.example.session_3.model.entity.Enrollment;
import com.example.session_3.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ApiResponse<List<Enrollment>> getAll() {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        return new ApiResponse<>(true, "Fetched all enrollments", enrollments);
    }

    @GetMapping("/{id}")
    public ApiResponse<Enrollment> getById(@PathVariable Long id) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        return new ApiResponse<>(true, "Fetched enrollment with id " + id, enrollment);
    }

    @PostMapping
    public ApiResponse<Enrollment> create(@RequestBody Enrollment enrollment) {
        Enrollment created = enrollmentService.createEnrollment(enrollment);
        return new ApiResponse<>(true, "Enrollment created successfully", created);
    }

    @PutMapping("/{id}")
    public ApiResponse<Enrollment> update(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        Enrollment updated = enrollmentService.updateEnrollment(id, enrollment);
        return new ApiResponse<>(true, "Enrollment updated successfully", updated);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return new ApiResponse<>(true, "Enrollment deleted successfully", null);
    }

}
