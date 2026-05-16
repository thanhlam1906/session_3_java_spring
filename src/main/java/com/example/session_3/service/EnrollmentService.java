package com.example.session_3.service;

import com.example.session_3.exception.InstructorNotFoundException;
import com.example.session_3.exception.InvalidCourseStateException;
import com.example.session_3.model.dto.EnrollCourseRequest;
import com.example.session_3.model.dto.EnrollmentDetail;
import com.example.session_3.model.entity.Course;
import com.example.session_3.model.entity.Enrollment;
import com.example.session_3.model.entity.statusCourse;
import com.example.session_3.repository.CourseRepository;
import com.example.session_3.repository.EnrollmentRepository;
import com.example.session_3.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository  enrollmentRepository;
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
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
    public EnrollmentDetail enroll(EnrollCourseRequest request){
        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + request.getCourseId()));

        System.out.println("[DEBUG] Course ID: " + course.getId() + ", Status: " + course.getStatus() + ", Status type: " + course.getStatus().getClass());

        if (!course.getStatus().equals(statusCourse.ACTIVE)){
            throw new InvalidCourseStateException("Course with id " + request.getCourseId() + " is not active. Current status: " + course.getStatus());
        }
        if(instructorRepository.findById(course.getInstructorId()).isEmpty()){
            throw new InstructorNotFoundException("Instructor not found with id: " + course.getInstructorId());
        }
        EnrollmentDetail detail = new EnrollmentDetail();
        detail.setId(request.getId());
        detail.setStudentName(request.getStudentName());
        detail.setCourse(course);

        return detail;
    }
}
