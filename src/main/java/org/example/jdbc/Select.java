package org.example.jdbc;

import org.example.entity.Student;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class Select {
    static final String url = "jdbc:mysql://localhost:3306/course";
    static final String user = "root";
    static final String password = "Orozbekov.02mysql";

    public static void main(String[] args) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = conn.prepareStatement(
                    "select * from student where avg_grade > ?"
            );
            ps.setDouble(1, 9.0);
            ResultSet resultSet = ps.executeQuery();
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId( resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setAvgGrate(resultSet.getDouble("avg_grade"));
                students.add(student);


            }
            System.out.println(students);


            ps.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
