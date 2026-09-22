package com.example.jav101_sd22101_bl1_fa26.B3_LamViecVoiForm;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {
        "/login",
        "/ket-qua",
}) // {liet ke tung duong dan }
// 1 servlet: co the k can chua name => bat buoc phai co value
// Value chua tat ca duong dan cua file dan cua file servlet
// Mot so loi hay gap k build duoc tomcat
// 1. Duong dan phai bat dau bang dau /
// 2. Duong dan la duy nhat => trong cung 1 project
// 3. Nghich file xml
public class LoginServlet extends HttpServlet {
    // BE - Servlet & FE - JSP
    // trao đổi vs nhau HTTP Methods: GET, POST, PUT, DELETE
    // Co ban: GET & POST
    // GET: => do GET
    // dung de hien thi
    // lay du lieu ra
    // form k can che thong tin
    // POST: form => che dau thong tin => do POST
    // format: intellij: Ctrl Alt L
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Truyền giá trị servlet -> jsp: setAttribute
        // ths1: String => ten bien cac ban tao
        // ths2: Object => gia tri gan cho bien cua ths1: String, List, Map.....
        int a = 5;
        String test = "Test gia tri truyen";
        request.setAttribute("mess", test);
        // Chuyen trang
        request.getRequestDispatcher("/login-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri jsp -> servlet (name): getParameter
        String username = request.getParameter("uname");
        String passs = request.getParameter("pass");
        // B2: Truyen gia tri sang jsp moi
        request.setAttribute("u1",username);
        request.setAttribute("u2",passs);
        // B3: Chuyen trang
        request.getRequestDispatcher("/ket-qua.jsp").forward(request, response);
    }
}
