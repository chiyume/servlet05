package com.chiyume.utils;

import java.sql.*;

public class JDBCUtils {
    // 加载驱动并建立数据库连接
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String databaseUrl = "jdbc:mysql://localhost:3306/servlet05";
        String username = "root";
        String password = "000000";
        Connection connection = DriverManager.getConnection(databaseUrl, username, password);
        return connection;
    }

    // 关闭数据库连接释放资源
    public static void release(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = null;
        }
    }

    // 关闭数据库连接释放资源
    public static void release(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }

    // 关闭数据库连接释放资源
    public static void release(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }

    // 关闭数据库连接释放资源
    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet = null;
        }
        release(statement, connection);
    }
}
