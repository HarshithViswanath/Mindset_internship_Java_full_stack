package com.feedbackportal.dao;

import com.feedbackportal.model.Admin;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.feedbackportal.util.DBUtil.getConnection;

public class AdminDAO {

    public Admin authenticate(ServletContext ctx, String email, String password) throws SQLException {
        String sql = "SELECT EMAIL, PWD FROM ADMIN WHERE EMAIL = ? AND PWD = ?";
        try (Connection c = getConnection(ctx);
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, email.trim().toLowerCase());
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                Admin a = new Admin();
                a.setEmail(rs.getString("EMAIL"));
                a.setPassword(rs.getString("PWD"));
                return a;
            }
        }
    }
}
