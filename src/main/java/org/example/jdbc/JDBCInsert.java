package org.example.jdbc;

import org.example.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsert {
    static String url = "JDBC:Mysql://localhost:3306/course";
    static String user = "root";
    static String password = "Orozbekov.02mysql";

    public static void main(String[] args) {
        Student student = new Student("Janybek", "King", 9.4);
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = conn.prepareStatement(
                    "INSERT INTO student(name, surname, avg_grade) VALUES (?,?,?)");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setDouble(3, student.getAvgGrade());
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
