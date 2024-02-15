package org.example.controllers;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.example.utils.CRUDUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    private final StudentService studentService;
    CRUDUtils crudUtils = new CRUDUtils();

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(value = "/all")
    public Student getStudentService() {
        return studentService.getStudent();
    }

    @GetMapping(value = "/id/{studentId}")
    public String getStudentName(@PathVariable String studentId){
        String name;
//        for (int i = 0; i < crudUtils.getStudents().size(); i++) {
//            if (studentService.getStudents(i).getId().equals(studentId)){
//                name = studentService.getStudents(i).getName();
//            }
//        }
//        if (name == null) {
//            return "Id \"" + studentId + "\" нет в бд";
//        }
        name = crudUtils.getStudentByString(studentId, "name", "id");
        if (name == null){
            return "В бд нет такого id \"" + studentId+ "\"";
        }
        return name;
    }

    @GetMapping(value = "/name/{studentName}")
    public String getStudentId(@PathVariable String studentName){
        String id;
//        for (int i = 0; i < crudUtils.getStudents().size(); i++) {
//            if (studentService.getStudents(i).getName().equals(studentName)){
//                id = studentService.getStudents(i).getId();
//            }
//        }
//        if (id == null) {
//            return "Name \"" + studentName +"\" нет в бд";
//        }
        id = crudUtils.getStudentByString(studentName, "id", "name");
        if (id == null){
            return "В бд нет такого name \"" + studentName + "\"";
        }
        return id;
    }
}
