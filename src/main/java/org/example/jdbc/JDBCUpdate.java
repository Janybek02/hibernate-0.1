package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCUpdate {
    static String url = "jdbc:mysql://localhost:3306/course";
    static String user = "root";
    static String password = "Orozbekov.02mysql";
    public static void main(String[] args) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter student name");
            String newName = sc.nextLine();

            Statement stmt = conn.createStatement();
            String sql = "UPDATE student SET avg_grade = 7.5 " + " WHERE name = '" + newName + "'" ;
            stmt.executeUpdate(sql);
            System.out.println("Student name updated");
        } catch (SQLException e) {
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
