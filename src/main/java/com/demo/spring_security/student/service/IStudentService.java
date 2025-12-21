package com.demo.spring_security.student.service;

import com.demo.spring_security.student.dto.StudentDto;
import com.demo.spring_security.student.model.Student;

import java.util.List;

public interface IStudentService {
    StudentDto createStudent(StudentDto student);

    List<StudentDto> getStudents();
}
