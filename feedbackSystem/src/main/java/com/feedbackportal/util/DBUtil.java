package com.feedbackportal.util;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBUtil {

    private DBUtil() {
    }

    public static Connection getConnection(ServletContext ctx) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found in classpath", e);
        }

        String url = ctx.getInitParameter("jdbc.url");
        String user = ctx.getInitParameter("jdbc.user");
        String password = ctx.getInitParameter("jdbc.password");
        if (password == null) {
            password = "";
        }
        return DriverManager.getConnection(url, user, password);
    }
}
