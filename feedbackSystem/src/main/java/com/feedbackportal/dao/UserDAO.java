package com.feedbackportal.dao;

import com.feedbackportal.model.User;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.feedbackportal.util.DBUtil.getConnection;

public class UserDAO {

    public boolean register(ServletContext ctx, User user) throws SQLException {
        String sql = "INSERT INTO REGISTRTION (NAME, MOBILE, EMAIL, PWD) VALUES (?, ?, ?, ?)";
        try (Connection c = getConnection(ctx);
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getMobile());
            ps.setString(3, user.getEmail().trim().toLowerCase());
            ps.setString(4, user.getPassword());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                return false;
            }
            throw e;
        }
    }

    public User findByEmail(ServletContext ctx, String email) throws SQLException {
        String sql = "SELECT NAME, MOBILE, EMAIL, PWD FROM REGISTRTION WHERE EMAIL = ?";
        try (Connection c = getConnection(ctx);
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, email.trim().toLowerCase());
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                User u = new User();
                u.setName(rs.getString("NAME"));
                u.setMobile(rs.getString("MOBILE"));
                u.setEmail(rs.getString("EMAIL"));
                u.setPassword(rs.getString("PWD"));
                return u;
            }
        }
    }

    public List<User> findAll(ServletContext ctx) throws SQLException {
        String sql = "SELECT NAME, MOBILE, EMAIL FROM REGISTRTION ORDER BY NAME";
        List<User> list = new ArrayList<>();
        try (Connection c = getConnection(ctx);
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User u = new User();
                u.setName(rs.getString("NAME"));
                u.setMobile(rs.getString("MOBILE"));
                u.setEmail(rs.getString("EMAIL"));
                list.add(u);
            }
        }
        return list;
    }
}
