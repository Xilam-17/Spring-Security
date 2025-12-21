package com.demo.spring_security.student.controller;

import com.demo.spring_security.student.dto.StudentDto;
import com.demo.spring_security.student.model.Student;
import com.demo.spring_security.student.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final IStudentService service;

    public StudentController(IStudentService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(service.createStudent(studentDto), HttpStatus.CREATED);
    }

    @GetMapping("/student-list")
    public ResponseEntity<List<StudentDto>> getStudents() {
        return new ResponseEntity<>(service.getStudents(), HttpStatus.OK);
    }
}
