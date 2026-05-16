package com.example.session_3.repository;

import com.example.session_3.model.entity.Course;
import com.example.session_3.model.entity.statusCourse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import jakarta.annotation.PostConstruct;
@Repository
public class CourseRepository {
    private final List<Course> courses = new ArrayList<>();

    @PostConstruct
    public void initData(){
        courses.add(
                Course.builder().id(2).title("test1").status(statusCourse.ACTIVE).instructorId(1).build()
        );
        courses.add(
                Course.builder().id(3).title("test2").status(statusCourse.INACTIVE).instructorId(2).build()
        );
        System.out.println("[initData] CourseRepository initialized with " + courses.size() + " courses");
    }

    public List<Course> findAll() {
        return courses;
    }
    public Optional<Course> findById(long id){
        return courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst();
    }
    public Course create(Course course){
        courses.add(course);
        return course;
    }
    public Course update(long id, Course course){
        Course existingCourse = findById(id).orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        existingCourse.setTitle(course.getTitle());
        existingCourse.setStatus(course.getStatus());
        existingCourse.setInstructorId(course.getInstructorId());
        return existingCourse;
    }
    public Course delete(long id){
        Course existingCourse = findById(id).orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        courses.remove(existingCourse);
        return null;
    }
}
