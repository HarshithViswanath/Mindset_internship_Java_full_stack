package com.feedbackportal.controller;

import com.feedbackportal.dao.FeedbackDAO;
import com.feedbackportal.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/dashboard")
public class AdminDashboardServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();
    private final FeedbackDAO feedbackDAO = new FeedbackDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("userCount", userDAO.findAll(getServletContext()).size());
            req.setAttribute("feedbackCount", feedbackDAO.count(getServletContext()));
        } catch (SQLException e) {
            throw new ServletException("Could not load dashboard data", e);
        }
        req.getRequestDispatcher("/WEB-INF/jsp/admin/dashboard.jsp").forward(req, resp);
    }
}
