package org.example.utils;

import org.example.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {

    public List<Student> addStudent(String id, String name){
        List<Student> listStudent = new ArrayList<>();
        try(Connection conn = new DBConnection().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.INSERT.getQuery())) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            listStudent = getStudents();
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return  listStudent;
    }

    public List<Student> getStudents() {
        List<Student> listStudent = new ArrayList<>();
        try(Connection conn = new DBConnection().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.SELECT.getQuery())) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                listStudent.add(new Student(id, name));
            }
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return listStudent;
    }

    public List<Student> updateStudents(String id, String name) {
        List<Student> listStudent = new ArrayList<>();
        try(Connection conn = new DBConnection().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.UPDATE.getQuery())) {
            preparedStatement.setString(2, id);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            listStudent = getStudents();
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return listStudent;
    }

    public List<Student> deleteStudents(String studentName) {
        List<Student> listStudent = new ArrayList<>();
        try(Connection conn = new DBConnection().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.DELETE.getQuery())) {
            preparedStatement.setString(1, studentName);
            preparedStatement.executeUpdate();
            listStudent = getStudents();
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return listStudent;
    }
}
