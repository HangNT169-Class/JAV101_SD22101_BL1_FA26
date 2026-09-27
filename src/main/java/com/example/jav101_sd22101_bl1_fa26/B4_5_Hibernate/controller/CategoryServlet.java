package com.example.jav101_sd22101_bl1_fa26.B4_5_Hibernate.controller;

import com.example.jav101_sd22101_bl1_fa26.B4_5_Hibernate.entity.Category1;
import com.example.jav101_sd22101_bl1_fa26.B4_5_Hibernate.repository.CategoryRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet(name = "CategoryServlet", value = {
        // 1 duong dan jsp -> KHONG CHAY TREN WWEBSITE CHI O PHAN REQUEST.GETDIPATCHER
        // 2 DUONG DAN TREN WEB -> VALUE TRONG SERVLET
        // duong dan tren website => de bai cho
        // CHI DE POST:
        // 1. FORM
        // 2. THONG TIN KHI THUC HIEN CHUC NANG -> CAN CHE GIAU THONG TIN
        "/category/hien-thi", // GET
        "/category/detail",  // GET
        "/category/delete",  // GET
        "/category/view-update", // GET
        "/category/update", // POST
        "/category/search", // GET
        "/category/view-add", // GET
        "/category/add", // POST
})
public class CategoryServlet extends HttpServlet {

    private CategoryRepository cateRepo = new CategoryRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 6 TH
        // kiem tra chua: contains
//        "/category/hien-thi" => "detail"
        // URL: http://localhost:8080/category/delete
        // B1: Lay uri tren duong dan
        String uri = request.getRequestURI();
        System.out.println("URI la: " + uri);
        if (uri.contains("hien-thi")) {
            // chuc nang hien thi
            this.hienThiCategory(request, response);
        } else if (uri.contains("detail")) {
            this.detailCategory(request, response);
        } else if (uri.contains("delete")) {
            this.deleteCategory(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateCategory(request, response);
        } else if (uri.contains("search")) {
            this.searchCategory(request, response);
        } else {
            this.viewAddCategory(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 2TH
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateCategory(request, response);
        } else {
            this.addCategory(request, response);
        }
    }

    @SneakyThrows
    private void addCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Category1 cate = new Category1();
        // B1: Lay toan bo gia tri cua cac o input jsp
        // BeanUtil -> mapping toan bo gia tri input - tu dong mapping
        // MAPPING NAME INPUT TRUNG NAME ENTITY
        BeanUtils.populate(cate,request.getParameterMap());
        // B2: Goi add trong cate
        cateRepo.add(cate);
        // B3: Quay ve trang hien thi
        response.sendRedirect("/category/hien-thi");
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAddCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi3/add-category.jsp").forward(request, response);
    }

    private void searchCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay ra gia tri duoc truyen tren duong dan
        String id = request.getParameter("id");
        // B2: Lay ra doi tuong detail
        Category1 cate = cateRepo.getOne(Long.valueOf(id));
        // B3: Truyen gia tri cate -> jsp
        request.setAttribute("cate1", cate);
        // B4: Chuyen trang
        request.getRequestDispatcher("/buoi3/update-cate.jsp")
                .forward(request, response);
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // B1: Lay ra gia tri duoc truyen tren duong dan
        String id = request.getParameter("a");
        Category1 cate = cateRepo.getOne(Long.valueOf(id));
        // B2: Goi ham xoa trong repo
        cateRepo.delete(cate);
        // B3: Chuyen trang - c2 => category/hien-thi
        response.sendRedirect("/category/hien-thi");
    }

    private void detailCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay ra gia tri duoc truyen tren duong dan
        String id = request.getParameter("id");
        // B2: Lay ra doi tuong detail
        Category1 cate = cateRepo.getOne(Long.valueOf(id));
        // B3: Truyen gia tri cate -> jsp
        request.setAttribute("cate1", cate);
        // B4: Chuyen trang
        request.getRequestDispatcher("/buoi3/detail-cate.jsp")
                .forward(request, response);
    }

    private void hienThiCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay ra list -> getAll
//        List<Category1>lists = cateRepo.getAll();
        // B2: Truyen bien servlet -> jsp
//        request.setAttribute("lists1",lists);
        request.setAttribute("listsCate", cateRepo.getAll());
        // chuyen trang
        request.getRequestDispatcher("/buoi3/categorys.jsp").forward(request, response);
    }
}
