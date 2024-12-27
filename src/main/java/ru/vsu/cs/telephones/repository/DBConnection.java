package ru.vsu.cs.telephones.repository;

import java.sql.SQLException;

import java.sql.*;

public interface DBConnection {

    public Connection initConnection() throws SQLException;
}
