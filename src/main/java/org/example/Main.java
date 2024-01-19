package org.example;

import org.example.utils.CRUDUtils;
import org.example.utils.DBConnection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CRUDUtils crudUtils = new CRUDUtils();
        System.out.println(crudUtils.deleteStudents("Artem"));
    }
}