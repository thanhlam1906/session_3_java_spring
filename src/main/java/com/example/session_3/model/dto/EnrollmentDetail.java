package com.example.session_3.model.dto;

import com.example.session_3.model.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDetail {
    long id;
    String studentName;
    Course course;
}
