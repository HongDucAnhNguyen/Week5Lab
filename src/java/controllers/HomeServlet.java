/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user!= null){
        session.setAttribute("user", user );
        
        getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, res);
        }
        else{
            req.setAttribute("message", "");
            getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);
            res.sendRedirect("login");
        }
    }

    
}
