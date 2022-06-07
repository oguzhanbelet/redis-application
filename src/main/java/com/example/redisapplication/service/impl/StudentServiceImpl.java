package com.example.redisapplication.service.impl;

import com.example.redisapplication.model.Student;
import com.example.redisapplication.repository.StudentRepository;
import com.example.redisapplication.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentById(String id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("could not find city by id: " +id));
    }

    @Override
    public void deleteStudent(String id) {
        Student student = findStudentById(id);
        studentRepository.delete(student);
    }

    @Override
    public Student updateStudent(String id, Student student) {
        Student student1 = findStudentById(id);
        student1.setName(student.getName());
        student1.setGrade(student.getGrade());
        student.setGender(student.getGender());

        return studentRepository.save(student1);
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }
}
