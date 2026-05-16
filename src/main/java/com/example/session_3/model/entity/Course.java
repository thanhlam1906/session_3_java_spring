package com.example.session_3.model.entity;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    private long id;
    private String title;
    private statusCourse status;
    private long instructorId;
}
