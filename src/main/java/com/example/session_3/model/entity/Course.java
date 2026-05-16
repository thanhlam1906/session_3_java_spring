package com.example.session_3.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    private long id;
    private String title;
    private statusCourse status;
    private long instructorId;
}
