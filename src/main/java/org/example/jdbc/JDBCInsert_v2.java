package org.example.jdbc;

import org.example.entity.Student;

import java.sql.*;

public class JDBCInsert_v2 {
    static String url = "jdbc:mysql://localhost:3306/course";
    static String user = "root";
    static String password = "Orozbekov.02mysql";

    public static void main(String[] args) {
        Connection conn = null;
        Student student = new Student("Aidai", "queen", 10);
        try {
            conn= DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String sqlQuery = "INSERT INTO student(name, surname, avg_grade) VALUES" +
                    "('" + student.getName() + "','" + student.getSurname() + "'," + student.getAvgGrade() + ")";


            statement.executeUpdate(sqlQuery);
            System.out.println("Student inserted");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
