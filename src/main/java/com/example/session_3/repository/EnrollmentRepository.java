package com.example.session_3.repository;

import com.example.session_3.exception.EnrollmentNotFoundException;
import com.example.session_3.model.entity.Enrollment;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>();

    @PostConstruct
    public void initData(){
        enrollments.add(Enrollment.builder().id(1).instructorId(2).courseId(1).build());
        enrollments.add(Enrollment.builder().id(2).instructorId(2).courseId(2).build());
    }
    public List<Enrollment> findAll(){
        return enrollments;
    }
    public Optional<Enrollment> findById(long id){
        return enrollments.stream().filter(enrollment -> enrollment.getId() == id).findFirst();
    }
    public Enrollment create(Enrollment enrollment){
        enrollments.add(enrollment);
        return enrollment;
    }

    public Enrollment update(Long id, Enrollment newEnrollment) {
        Enrollment existEnrollment = findById(id)
                .orElseThrow(() -> new EnrollmentNotFoundException(id));

        existEnrollment.setCourseId(newEnrollment.getCourseId());
        existEnrollment.setInstructorId(newEnrollment.getInstructorId());
        existEnrollment.setCourseId(newEnrollment.getCourseId());
        return existEnrollment;
    }
    public Enrollment delete(long id){
        Enrollment existEnrollment = findById(id).orElseThrow(() -> new EnrollmentNotFoundException(id));
        enrollments.remove(existEnrollment);
        return existEnrollment;
    }
}
