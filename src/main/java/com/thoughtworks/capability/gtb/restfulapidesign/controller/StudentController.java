package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student) {
        studentService.save(student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudents(@PathVariable int studentId) {
        studentService.removeById(studentId);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(@RequestParam(name = "gender", required = false) Gender gender) {
        if (gender == null) {
            return studentService.findAll();
        }
        return studentService.findByGender(gender);
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        return studentService.findById(studentId);
    }

    @PatchMapping(path = "/students/{studentId}", consumes = "application/json-patch+json")
    public void updateStudent(@PathVariable int studentId, @RequestBody JsonPatch patch) {
        Student student = studentService.findById(studentId);
        try {
            Student studentPatched = applyPatchToStudent(patch, student);
            studentService.updateStudent(studentPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private Student applyPatchToStudent(
            JsonPatch patch, Student targetStudent) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(targetStudent, JsonNode.class));
        return objectMapper.treeToValue(patched, Student.class);
    }

}
