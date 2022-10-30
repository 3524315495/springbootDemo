package com.example.demo.demo06Jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class Test6 {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Test
    public void Test1() {
        try (Connection con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            try (Statement statement = con.createStatement()) {
                try (ResultSet resultSet = statement.
                        executeQuery("select id, grade, name, gender from students")) {
                    while (resultSet.next()) {
                        System.out.printf(String.valueOf(resultSet.getLong(1)));
                        System.out.printf(String.valueOf(resultSet.getLong(2)));
                        System.out.printf(resultSet.getString(3));
                        System.out.printf(String.valueOf(resultSet.getInt(4)));
                        System.out.println();
                    }
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void test2() throws SQLException {
        try (Connection con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            try (PreparedStatement stat = con.prepareStatement("select id, grade, name, gender" +
                    " from students where gender = ? and grade = ?;")) {
                stat.setObject(1, "M");
                stat.setObject(2, 3);
                try (ResultSet rs = stat.executeQuery()) {
                    while (rs.next()) {
                        System.out.printf(String.valueOf(rs.getLong("id")));
                        System.out.printf(String.valueOf(rs.getLong("grade")));
                        System.out.printf(rs.getString("name"));
                        System.out.printf(String.valueOf(rs.getString("gender")));
                        System.out.println();
                    }
                }
            }
        }
    }
}
