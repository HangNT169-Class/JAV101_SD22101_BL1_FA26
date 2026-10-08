package com.example.jav101_sd22101_bl1_fa26.B11_Scope_JSP_Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Login1Servlet", value = "/Login1Servlet")
public class Login1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username","Test 124");
        // Khai bao 1 session
        HttpSession session = request.getSession();
        session.setAttribute("testSession","Message Session Login");
        request.getRequestDispatcher("/buoi11/login-form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
