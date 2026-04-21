package com.feedbackportal.controller;

import com.feedbackportal.dao.FeedbackDAO;
import com.feedbackportal.model.FeedbackEntry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/feedback/submit")
public class FeedbackSubmitServlet extends HttpServlet {

    private final FeedbackDAO feedbackDAO = new FeedbackDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"USER".equals(session.getAttribute("role"))) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp?error=feedback");
            return;
        }

        String name = req.getParameter("name");
        String emailId = req.getParameter("emailId");
        String text = req.getParameter("feedback");
        if (name == null || name.isBlank() || emailId == null || emailId.isBlank()
                || text == null || text.isBlank()) {
            resp.sendRedirect(req.getContextPath() + "/submit-feedback.jsp?error=missing");
            return;
        }

        FeedbackEntry entry = new FeedbackEntry();
        entry.setName(name.trim());
        entry.setEmailId(emailId.trim());
        entry.setFeedback(text.trim());
        try {
            feedbackDAO.insert(getServletContext(), entry);
        } catch (SQLException e) {
            throw new ServletException("Could not save feedback", e);
        }
        resp.sendRedirect(req.getContextPath() + "/submit-feedback.jsp?success=1");
    }
}
