package org.example.service;

import org.example.entity.Student;
import org.example.interfaces.StudentServiceInterface;
import org.example.utils.CRUDUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentServiceInterface {

    @Override
    public Student getStudent() {
        CRUDUtils crudUtils = new CRUDUtils();
        return crudUtils.getStudents("*", "test_table").get(0);
    }

    public Student getStudents(int index){
        CRUDUtils crudUtils = new CRUDUtils();;
        return crudUtils.getStudents("*", "test_table").get(index);
    }


}
