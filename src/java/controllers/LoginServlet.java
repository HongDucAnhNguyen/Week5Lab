/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.service.AccountService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author nguye
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (req.getParameter("logout") != null) {
            session.invalidate();
            req.setAttribute("message", "you have successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);
            res.sendRedirect("login");
        }
        if (session != null) {
            res.sendRedirect("home");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User service = new AccountService().login(username, password);
        HttpSession session = req.getSession();
        if (username == null || username.equals("") || password == null || password.equals("")) {
            req.setAttribute("message", "please fill out the form");
            getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);
        } else if (service != null) {
            session.setAttribute("user", service);
            res.sendRedirect("home");
        } else {
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("message", "invalid credentials");
            getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);
        }
    }

}
