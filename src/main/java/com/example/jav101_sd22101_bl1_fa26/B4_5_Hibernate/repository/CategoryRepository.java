package com.example.jav101_sd22101_bl1_fa26.B4_5_Hibernate.repository;

import com.example.jav101_sd22101_bl1_fa26.B4_5_Hibernate.entity.Category1;
import com.example.jav101_sd22101_bl1_fa26.B4_5_Hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CategoryRepository {
    // Phien lam viec -> 1 phien lam viec -> 1 session
    private Session s;

    public CategoryRepository() {
        // mo phien session
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<Category1> getAll() {
        // TRUY VAN TREN THUC THE -> SELECT ENTITY
        return s.createQuery("FROM Category1").list();
    }

    public Category1 getOne(Long id1) {
        return s.find(Category1.class, id1); // Chi ap dung voi ham tim kiem theo id tra id tra ve 1 ds
    }

    public void add(Category1 cate){
        // transation -> tinh toan ven
        try{
            // B1: Bat dau 1 transation
            s.getTransaction().begin();
            // B2: Thuc hien chuc nang add => persit
            s.persist(cate);
            // B3: Commit
            s.getTransaction().commit();
        }catch (Exception e){
            s.getTransaction().rollback(); // Loi -> Quay ve trang thai ban dau
            e.printStackTrace();
        }
    }

    public void update(Category1 cate){
        // transation -> tinh toan ven
        try{
            // B1: Bat dau 1 transation
            s.getTransaction().begin();
            // B2: Thuc hien chuc nang add => merge
            s.merge(cate);
            // B3: Commit
            s.getTransaction().commit();
        }catch (Exception e){
            s.getTransaction().rollback(); // Loi -> Quay ve trang thai ban dau
            e.printStackTrace();
        }
    }
    public void delete(Category1 cate){
        // transation -> tinh toan ven
        try{
            // B1: Bat dau 1 transation
            s.getTransaction().begin();
            // B2: Thuc hien chuc nang add => delete
            s.delete(cate);
            // B3: Commit
            s.getTransaction().commit();
        }catch (Exception e){
            s.getTransaction().rollback(); // Loi -> Quay ve trang thai ban dau
            e.printStackTrace();
        }
    }
    // ddam bao phai ra du lieu getAll
    // Category1 is not mapped
    // 1. Chua them @entity trong class
    // 2. Chua dang ky trong HibernateUtil
    // Invalid column name 'category_code1'. => Ss maping cac class thuoc entiy so vs SQL
    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getOne(1L));
    }
}

