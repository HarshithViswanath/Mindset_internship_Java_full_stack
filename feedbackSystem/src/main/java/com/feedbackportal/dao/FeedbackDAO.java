package com.feedbackportal.dao;

import com.feedbackportal.model.FeedbackEntry;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.feedbackportal.util.DBUtil.getConnection;

public class FeedbackDAO {

    public void insert(ServletContext ctx, FeedbackEntry entry) throws SQLException {
        String sql = "INSERT INTO FEEDBACK (NAME, EMAILID, FEEDBACK) VALUES (?, ?, ?)";
        try (Connection c = getConnection(ctx);
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, entry.getName());
            ps.setString(2, entry.getEmailId().trim().toLowerCase());
            ps.setString(3, entry.getFeedback());
            ps.executeUpdate();
        }
    }

    public List<FeedbackEntry> findAll(ServletContext ctx) throws SQLException {
        String sql = "SELECT ID, NAME, EMAILID, FEEDBACK, CREATED_AT FROM FEEDBACK ORDER BY CREATED_AT DESC";
        List<FeedbackEntry> list = new ArrayList<>();
        try (Connection c = getConnection(ctx);
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                FeedbackEntry f = new FeedbackEntry();
                f.setId(rs.getInt("ID"));
                f.setName(rs.getString("NAME"));
                f.setEmailId(rs.getString("EMAILID"));
                f.setFeedback(rs.getString("FEEDBACK"));
                f.setCreatedAt(rs.getString("CREATED_AT"));
                list.add(f);
            }
        }
        return list;
    }

    public int count(ServletContext ctx) throws SQLException {
        String sql = "SELECT COUNT(*) AS C FROM FEEDBACK";
        try (Connection c = getConnection(ctx);
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("C");
            }
        }
        return 0;
    }
}
