package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dataProvider.DataProvider;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    private final List<Student> studentList = DataProvider.studentList;

    public void save(Student student) {
        studentList.add(student);
    }
}
