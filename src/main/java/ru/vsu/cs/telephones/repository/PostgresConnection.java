package ru.vsu.cs.telephones.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgresConnection implements DBConnection {

    private String url = "jdbc:postgresql://app-db:5432/Telephones_DB";
    private String name = "admin";
    private String password = "pass";

    @Override
    public Connection initConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);
        } catch (Exception ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
