package com.klu.studentlearningtracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.studentlearningtracer.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}
