package com.example.Documents;

import java.sql.*;

public class CachedDocument implements Document {
    private Document document;
    private Connection connection; // SQLite database connection

    public CachedDocument(Document document, Connection connection) {
        this.document = document;
        this.connection = connection;
        try {
            // Establish the connection to the SQLite database
            this.connection = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String parse() {
        String cachedContent = retrieveFromCache();

        if (cachedContent != null) {
            System.out.println("Content retrieved from cache.");
            return cachedContent;
        } else {
            // Parse content and store in cache
            String parsedContent = document.parse();
            storeInCache(parsedContent);
            return parsedContent;
        }
    }

    private String retrieveFromCache() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT content FROM CacheTable WHERE id = ?");
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("content");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void storeInCache(String content) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CacheTable(content) VALUES(?)");
            preparedStatement.setString(1, content);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
