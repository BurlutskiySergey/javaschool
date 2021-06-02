package ru.sber.javaschool.examplejdbc;

import java.sql.*;
import java.util.Optional;
import java.util.function.Consumer;

public class ExampleJDBC {
    private String url;

    public ExampleJDBC(String url) {
        this.url = url;
    }

    /* old style */
    public Optional<String> selectColumn() throws SQLException {
        try(Connection connection = getConnection().orElseThrow(JDBCConnectionException::new)) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet resultSet = statement.executeQuery("select name from machine")) {
                    if (resultSet.next()) {
                        return Optional.of(resultSet.getString("NAME"));
                    } else {
                        return Optional.empty();
                    }
                }
            }
        }
    }

    /* new style */
    public void selectColumns(Consumer<String> consumer) throws SQLException {
        try(Connection connection = getConnection().orElseThrow(JDBCConnectionException::new)) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet resultSet = statement.executeQuery("select name, age from animal")) {
                    while (resultSet.next()) {
                        consumer.accept("Name: " + resultSet.getString("NAME") + ", age: " + resultSet.getString("age"));
                    }
                }
            }
        }
    }

    private Optional<Connection> getConnection() throws SQLException {
        return Optional.ofNullable(DriverManager.getConnection(url));
    }

}
