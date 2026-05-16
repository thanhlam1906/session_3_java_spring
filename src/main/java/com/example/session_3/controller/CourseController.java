package com.example.session_3.controller;

import com.example.session_3.model.dto.ApiResponse;
import com.example.session_3.model.entity.Course;
import com.example.session_3.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<List<Course>>>  getAllCourses(){
        try{
            return ResponseEntity.ok(new ApiResponse<>(true, "Success", courseService.getAllCourse()));
        } catch (Exception e){
            return ResponseEntity.status(500).body(new ApiResponse<>(false, "Error: " + e.getMessage(), null));
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable long id){
        try {
            Course course = courseService.getCourseById(id);
            return ResponseEntity.ok(new ApiResponse<>(true, "Course found", course));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Error: " + e.getMessage(), null));
        }
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Course>> createCourse(@RequestBody Course course){
        try {
            Course createdCourse = courseService.createCourse(course);
            return ResponseEntity.ok(new ApiResponse<>(true, "Course created successfully", createdCourse));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, "Error: " + e.getMessage(), null));
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@PathVariable long id, @RequestBody Course course) {
        try {
            Course updatedCourse = courseService.updateCourse(id, course);
            return ResponseEntity.ok(new ApiResponse<>(true, "Course updated successfully", updatedCourse));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, "Error: " + e.getMessage(), null));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCourse(@PathVariable long id) {
        try {
            courseService.deleteCourse(id);
            return ResponseEntity.ok(new ApiResponse<>(true, "Course deleted successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, "Error: " + e.getMessage(), null));
        }
    }
}
