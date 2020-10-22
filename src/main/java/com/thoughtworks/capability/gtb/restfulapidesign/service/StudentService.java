package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.exception.InvalidStudentException;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) {
        if (studentRepository.findById(student.getId()) != null) {
            throw new InvalidStudentException("学生已存在！");
        }
        studentRepository.save(student);
    }

    public void removeById(int studentId) {
        boolean isRemoved = studentRepository.removeById(studentId);
        if (!isRemoved) {
            throw new InvalidStudentException("学生不存在！");
        }
    }

    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> findByGender(Gender gender) {
        List<Student> studentList = studentRepository.findByGender(gender);
        if (studentList.size() == 0) {
            throw new InvalidStudentException("没有该性别学生！");
        }
        return studentList;
    }

    public Student findById(int studentId) {
        Student student = studentRepository.findById(studentId);
        if (student == null) {
            throw new InvalidStudentException("学生不存在！");
        }
        return student;
    }
}
