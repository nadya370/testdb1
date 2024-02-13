package org.example.controllers;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(value = "/all")
    public Student getStudentService() {
        return studentService.getStudent();
    }

    @GetMapping(value = "/id/{studentId}")
    public String getStudentName(@PathVariable int studentId){
        if (studentId == 2){
            return studentService.getStudent().getName();
        }
        return "enter 2";
    }

    @GetMapping(value = "/name/{studentName}")
    public String getStudentName(@PathVariable String studentName){
        if (studentName.equals("Nadezhda")){
            return studentService.getStudent().getId();
        }
        return "enter Nadezhda";
    }

}
