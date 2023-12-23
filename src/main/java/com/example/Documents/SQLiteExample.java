package com.example.Documents;

import java.sql.*;

public class SQLiteExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:mydatabase.db";
        try (Connection connection = DriverManager.getConnection(url)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS CacheTable (id INTEGER PRIMARY KEY AUTOINCREMENT, content TEXT)";
            try (Statement statement = connection.createStatement()) {
                statement.execute(createTableSQL);
            }
            System.out.println("SQLite database and table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

