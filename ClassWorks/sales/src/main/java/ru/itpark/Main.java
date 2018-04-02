package ru.itpark;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Z:db.sqlite");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id,name FROM managers");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + " : " + name);
            }


            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
