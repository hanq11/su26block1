package com.example.sd22132jav201.bvbs.repository;

import com.example.sd22132jav201.bvbs.entity.BacSi;
import com.example.sd22132jav201.bvbs.entity.BenhVien;
import com.example.sd22132jav201.bvbs.util.HibernateConfigBvbs;
import org.hibernate.Session;

import java.util.List;

public class BacSiRepository {
    private Session session = null;

    public BacSiRepository() {
        session = HibernateConfigBvbs.getFACTORY().openSession();
    }

    public List<BacSi> getAll() {
        return session.createQuery("FROM BacSi bs").list();
    }

    public List<BenhVien> getAllBenhVien() {
        return session.createQuery("FROM BenhVien bv").list();
    }

    public BenhVien getBenhVienById(Integer id) {
        return session.find(BenhVien.class, id);
    }

    public void themBacSi(BacSi bacSi) {
        try {
            session.getTransaction().begin();
            session.save(bacSi);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public BacSi getBacSiById(Integer id) {
        return session.find(BacSi.class, id);
    }

    public void updateBacSi(BacSi bacSi) {
        try {
            session.getTransaction().begin();
            session.merge(bacSi);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void xoaBacSi(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getBacSiById(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
