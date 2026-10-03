package com.example.jav101_sd22101_bl1_fa26.B8_Hibernate_Advance.controller;

import com.example.jav101_sd22101_bl1_fa26.B8_Hibernate_Advance.entity.BaiHat;
import com.example.jav101_sd22101_bl1_fa26.B8_Hibernate_Advance.repository.BaiHatRepository;
import com.example.jav101_sd22101_bl1_fa26.B8_Hibernate_Advance.repository.CaSiRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BaiHatServlet", value = "/bai-hat/hien-thi")
public class BaiHatServlet extends HttpServlet {
    private BaiHatRepository bhRepo = new BaiHatRepository();
    private CaSiRepository csRepo = new CaSiRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiBaiHat(request, response);
        }
    }

    private void hienThiBaiHat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BaiHat> listBh = bhRepo.getAll();
        request.setAttribute("listBH", listBh);
        request.setAttribute("listCS",csRepo.getAll());
        request.getRequestDispatcher("/bai-hat.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
