package com.feedbackportal.controller;

import com.feedbackportal.dao.FeedbackDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/feedbacks")
public class AdminFeedbacksServlet extends HttpServlet {

    private final FeedbackDAO feedbackDAO = new FeedbackDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("feedbacks", feedbackDAO.findAll(getServletContext()));
        } catch (SQLException e) {
            throw new ServletException("Could not load feedback", e);
        }
        req.getRequestDispatcher("/WEB-INF/jsp/admin/feedbacks.jsp").forward(req, resp);
    }
}
