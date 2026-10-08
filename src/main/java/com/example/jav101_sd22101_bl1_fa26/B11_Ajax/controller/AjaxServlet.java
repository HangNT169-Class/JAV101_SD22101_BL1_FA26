package com.example.jav101_sd22101_bl1_fa26.B11_Ajax.controller;

import com.example.jav101_sd22101_bl1_fa26.B11_Ajax.entity.SinhVien;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxServlet", value = "/api/sinh-vien/hien-thi")
public class AjaxServlet extends HttpServlet {

    // AJAX -> JSON
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Chuan bi du lieu
        SinhVien sv = new SinhVien("SV01","Nguyen Van A",10);
        // Tuy de bai:
        // De bai bao 1 doi tuong -> tao 1 doi tuong
        // De bai yeu cau chuyen doi len table -> tao 1 list danh sach
        // B2: Chuyen doi du lieu o B1
        Gson gson = new Gson();
        // Chuyen doi sang json
        String responseData = gson.toJson(sv);
        // B3: Set type cho chuyen doi
        response.setContentType("application/json");
        // Muon du lieu tren trinh duyet de kt => B4:
        PrintWriter out = response.getWriter();
        out.println(responseData);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
