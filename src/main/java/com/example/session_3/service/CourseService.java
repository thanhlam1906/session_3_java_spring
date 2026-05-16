package com.example.session_3.service;

import com.example.session_3.model.entity.Course;
import com.example.session_3.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }
    public Course getCourseById(Long id){
        return courseRepository.findById(id).orElseThrow(()-> new RuntimeException("Course not found with id: " + id));
    }
    public Course createCourse(Course course){
        return courseRepository.create(course);
    }
    public Course updateCourse(Long id, Course course){

        return courseRepository.update(id, course);
    }
    public Course deleteCourse(Long id){
        return courseRepository.delete(id);
    }

}
