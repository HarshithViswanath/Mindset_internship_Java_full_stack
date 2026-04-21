package com.feedbackportal.controller;

import com.feedbackportal.dao.UserDAO;
import com.feedbackportal.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("role") != null) {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        String name = req.getParameter("name");
        String mobile = req.getParameter("mobile");
        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");

        if (name == null || name.isBlank() || mobile == null || mobile.isBlank()
                || email == null || email.isBlank() || pwd == null || pwd.isBlank()) {
            resp.sendRedirect(req.getContextPath() + "/register.jsp?error=missing");
            return;
        }

        User user = new User(name.trim(), mobile.trim(), email.trim(), pwd);
        try {
            if (!userDAO.register(getServletContext(), user)) {
                resp.sendRedirect(req.getContextPath() + "/register.jsp?error=duplicate");
                return;
            }
        } catch (SQLException e) {
            throw new ServletException("Database error during registration", e);
        }
        resp.sendRedirect(req.getContextPath() + "/login.jsp?registered=1");
    }
}
