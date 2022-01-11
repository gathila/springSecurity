package com.example.ssp.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Gathila"),
            new Student(2, "Suresh"),
            new Student(3, "Darshana")
    );

    @GetMapping(path = "{studentId}")
    public Student find(@PathVariable("studentId") Integer id) {
        return STUDENTS.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + id + " not found"));
    }
}
