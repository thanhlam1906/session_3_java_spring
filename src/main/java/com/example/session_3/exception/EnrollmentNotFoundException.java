package com.example.session_3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnrollmentNotFoundException extends RuntimeException {
    public EnrollmentNotFoundException(Long id) {
        super("Enrollment not found with id: " + id);
    }
}

