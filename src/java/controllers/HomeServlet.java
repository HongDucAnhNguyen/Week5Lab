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

/**
 *
 * @author nguye
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || username.equals("") || password == null || password.equals("")) {
            req.setAttribute("message", "please fill out the form");
            getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);
        } else if((username.equals("abe")|| username.equals("barb")) && password.equals("password")) {
            req.setAttribute("user", new AccountService().login(username, password));
            getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, res);
        }
        else{
            req.setAttribute("message", "invalid credentials");
            getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);
        }
    }
}
