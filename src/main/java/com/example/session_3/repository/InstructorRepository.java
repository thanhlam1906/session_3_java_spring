package com.example.session_3.repository;

import com.example.session_3.model.entity.Course;
import com.example.session_3.model.entity.Enrollment;
import com.example.session_3.model.entity.Instructor;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InstructorRepository {
    private final List<Instructor> instructors = new ArrayList<>();

    @PostConstruct
    public void initData() {
        instructors.add(Instructor.builder()
                .id(1L)
                .name("Nguyen Van A")
                .email("a@example.com")
                .build());

        instructors.add(Instructor.builder()
                .id(2L)
                .name("Tran Thi B")
                .email("b@example.com")
                .build());


    }

    public List<Instructor> findAll() { return instructors; }
    public Instructor create(Instructor instructor) {
        instructors.add(instructor);
        return instructor;
    }
    public Optional<Instructor> findById(long id){
        return instructors.stream().filter(instructor -> instructor.getId() == id).findFirst();
    }
    public Instructor update(long id, Instructor instructor){
        Instructor existingInstructor = findById(id).orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        existingInstructor.setName(instructor.getName());
        existingInstructor.setEmail(instructor.getEmail());
        return existingInstructor;

    }
    public Instructor delete(long id){
        Instructor existingInstructor = findById(id).orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        instructors.remove(existingInstructor);
        return null;
    }
}
