package com.example.jav101_sd22101_bl1_fa26.B8_Hibernate_Advance.repository;

import com.example.jav101_sd22101_bl1_fa26.B8_Hibernate_Advance.entity.CaSi1;
import com.example.jav101_sd22101_bl1_fa26.B8_Hibernate_Advance.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CaSiRepository {
    private Session s;

    public CaSiRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<CaSi1> getAll() {
        return s.createQuery("from CaSi1 ").list();
    }

    public static void main(String[] args) {
        System.out.println(new CaSiRepository().getAll());
    }
}