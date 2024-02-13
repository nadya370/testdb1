package org.example.service;

import org.example.entity.Student;
import org.example.interfaces.StudentServiceInterface;
import org.example.utils.CRUDUtils;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInterface {

    @Override
    public Student getStudent() {
        CRUDUtils crudUtils = new CRUDUtils();
        return crudUtils.getStudents().get(0);
    }

}
