package com.example.redisapplication.service;

import com.example.redisapplication.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    Student findStudentById(String id);
    void deleteStudent(String id);
    Student updateStudent(String id, Student student);
    List<Student> getAllStudents();
}
