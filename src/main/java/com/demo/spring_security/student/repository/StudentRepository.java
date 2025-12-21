package com.demo.spring_security.student.repository;

import com.demo.spring_security.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
