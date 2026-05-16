package com.example.session_3.controller;

import com.example.session_3.model.dto.ApiResponse;
import com.example.session_3.model.entity.Instructor;
import com.example.session_3.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ApiResponse<List<Instructor>> getAll() {
        return new ApiResponse<>(true, "Fetched all instructors", instructorService.getAllInstructors());
    }

    @GetMapping("/{id}")
    public ApiResponse<Instructor> getById(@PathVariable Long id) {
        return new ApiResponse<>(true, "Fetched instructor with id " + id, instructorService.getInstructorById(id));
    }

    @PostMapping
    public ApiResponse<Instructor> create(@RequestBody Instructor instructor) {
        return new ApiResponse<>(true, "Instructor created successfully", instructorService.createInstructor(instructor));
    }

    @PutMapping("/{id}")
    public ApiResponse<Instructor> update(@PathVariable Long id, @RequestBody Instructor instructor) {
        return new ApiResponse<>(true, "Instructor updated successfully", instructorService.updateInstructor(id, instructor));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return new ApiResponse<>(true, "Instructor deleted successfully", null);
    }
}
