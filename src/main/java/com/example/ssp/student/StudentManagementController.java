package com.example.ssp.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Gathila"),
            new Student(2, "Suresh"),
            new Student(3, "Darshana")
    );


    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMIN_TRAINEE')")
    public List<Student> getAllStudents() {
        return STUDENTS;
    }


    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("registerNewStudent");
    }


    @PutMapping("{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        System.out.println("updateStudent");
        System.out.println(studentId);
    }


    @DeleteMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent() {
        System.out.println("deleteStudent");
    }
}
