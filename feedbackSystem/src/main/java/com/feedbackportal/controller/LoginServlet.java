package com.feedbackportal.controller;

import com.feedbackportal.dao.AdminDAO;
import com.feedbackportal.dao.UserDAO;
import com.feedbackportal.model.Admin;
import com.feedbackportal.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final AdminDAO adminDAO = new AdminDAO();
    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp?error=missing");
            return;
        }

        try {
            Admin admin = adminDAO.authenticate(getServletContext(), email, password);
            if (admin != null) {
                HttpSession session = req.getSession(true);
                session.setAttribute("role", "ADMIN");
                session.setAttribute("email", admin.getEmail());
                session.setAttribute("displayName", "Administrator");
                resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
                return;
            }

            User user = userDAO.findByEmail(getServletContext(), email);
            if (user != null && password.equals(user.getPassword())) {
                HttpSession session = req.getSession(true);
                session.setAttribute("role", "USER");
                session.setAttribute("email", user.getEmail());
                session.setAttribute("displayName", user.getName());
                resp.sendRedirect(req.getContextPath() + "/index.jsp?welcome=1");
                return;
            }
        } catch (SQLException e) {
            throw new ServletException("Database error during login", e);
        }

        resp.sendRedirect(req.getContextPath() + "/login.jsp?error=credentials");
    }
}
