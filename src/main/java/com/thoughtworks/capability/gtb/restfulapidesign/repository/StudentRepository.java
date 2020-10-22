package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dataprovider.DataProvider;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private final List<Student> studentList = DataProvider.studentList;

    public void save(Student student) {
        studentList.add(student);
    }

    public Student findById(int studentId) {
        return studentList.stream()
                .filter(student -> student.getId() == studentId)
                .findFirst()
                .orElse(null);
    }

    public boolean removeById(int studentId) {
        return studentList.removeIf(student -> student.getId() == studentId);
    }

    public List<Student> findAll() {
        return studentList;
    }

    public List<Student> findByGender(Gender gender) {
        return studentList.stream()
                .filter(student -> student.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public void updateStudent(Student student) {
        studentList.removeIf(stu -> stu.getId() == student.getId());
        studentList.add(student);
    }
}
