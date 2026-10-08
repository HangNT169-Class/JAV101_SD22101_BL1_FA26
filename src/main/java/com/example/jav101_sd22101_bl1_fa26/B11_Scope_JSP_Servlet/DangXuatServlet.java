package com.example.jav101_sd22101_bl1_fa26.B11_Scope_JSP_Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DangXuatServlet", value = "/dang-xuat")
public class DangXuatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // C1: Xoa toan bo bien session
//        session.invalidate();
        // C2: Xoa lan luot tung session
//        session.removeAttribute("testSession");
        // Goi session o servlet
        String value = (String) session.getAttribute("testSession");
        response.sendRedirect("/bai-hat/hien-thi");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
