package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private String host = "localhost";
    private String port = "5432";
    private String databaseName = "postgres";
    private String userName = "postgres";
    private String password = "";


    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + databaseName,
                    userName, password);
            System.out.println("Connection was successful");
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

//    public void getId(String query) {
//        try {
//            Statement stmt = connection().createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while(rs.next()){
//                System.out.println("ID: " + rs.getInt("id"));
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
