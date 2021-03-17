package com.ss.SimpleLogin;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "app", value = "/app")
public class App extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Susceptible to user injection?
        if ("smoothstack".equals(username) && "securePassword".equals(password)) {
            RequestDispatcher view = request.getRequestDispatcher("WEB-INF/app-page.html");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/?failure=true");
        }
    }

    public void destroy() {
    }
}