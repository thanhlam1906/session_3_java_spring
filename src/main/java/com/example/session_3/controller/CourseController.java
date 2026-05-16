package com.example.session_3.controller;

import com.example.session_3.model.dto.ApiResponse;
import com.example.session_3.model.entity.Course;
import com.example.session_3.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping
    public ApiResponse<List<Course>> getAllCourses(){
        return new ApiResponse<>(true, "Success", courseService.getAllCourse());
    }
    @PostMapping
    public ApiResponse<Course> createCourse(@RequestBody Course course){
        return new ApiResponse<>(true, "Course created successfully", courseService.createCourse(course));
    }
    @PutMapping("/{id}")
    public ApiResponse<Course> updateCourse(@PathVariable long id, @RequestBody Course course) {
        return new ApiResponse<>(true, "Course updated successfully", courseService.updateCourse(id, course));
    }
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteCourse(@PathVariable long id) {
        courseService.deleteCourse(id);
        return new ApiResponse<>(true, "Course deleted successfully", null);
    }
}
