package com.klu.studentlearningtracer.service;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klu.studentlearningtracer.model.Student;
import com.klu.studentlearningtracer.repository.StudentRepository;
import org.springframework.data.repository.CrudRepository;
@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student addStudent(Student student) {
        return repository.save(student);
        
    }
    public Student getStudentById(Long id) {
        Optional<Student> student = repository.findById(id);
        return student.orElse(null); // Return null if student is not found
    }
    
}