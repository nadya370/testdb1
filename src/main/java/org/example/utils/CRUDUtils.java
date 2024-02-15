package org.example.utils;

import org.example.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;


public class CRUDUtils {


    public List<Student> addStudent(String id, String name, String table){
        List<Student> listStudent = new ArrayList<>();
        try(Connection conn = new DBConnection().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    MessageFormat.format(QueryTypes.INSERT.getQuery(), table))) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            listStudent = getStudents("*", "test_table");
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return  listStudent;
    }

    public String getStudentByString(String string, String firstArg, String table, String secondArg) {
        String name = null;
        try(Connection conn = new DBConnection().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    MessageFormat.format(QueryTypes.SELECT_FROM.getQuery(),
                    firstArg,
                    table,
                    secondArg))) {
            preparedStatement.setString(1, string);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                name = resultSet.getString(firstArg);
            }

        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    public List<Student> getStudents(String firstArg, String table) {
        List<Student> listStudent = new ArrayList<>();
        try(Connection conn = new DBConnection().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    MessageFormat.format(QueryTypes.SELECT.getQuery(), firstArg, table))) {
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

    public List<Student> updateStudents(String id, String name, String table, String firstArg, String secondArg) {
        List<Student> listStudent = new ArrayList<>();
        try(Connection conn = new DBConnection().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    MessageFormat.format(QueryTypes.UPDATE.getQuery(), table, firstArg, secondArg))) {
            preparedStatement.setString(2, id);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            listStudent = getStudents("*", "test_table");
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return listStudent;
    }

    public List<Student> deleteStudents(String studentName, String table, String firstArg) {
        List<Student> listStudent = new ArrayList<>();
        try(Connection conn = new DBConnection().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    MessageFormat.format(QueryTypes.DELETE.getQuery(), table, firstArg))) {
            preparedStatement.setString(1, studentName);
            preparedStatement.executeUpdate();
            listStudent = getStudents("*", "test_table");
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return listStudent;
    }
}
