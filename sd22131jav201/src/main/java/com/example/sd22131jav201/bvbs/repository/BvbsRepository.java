package com.example.sd22131jav201.bvbs.repository;

import com.example.sd22131jav201.bvbs.entity.BacSi;
import com.example.sd22131jav201.bvbs.entity.BenhVien;
import com.example.sd22131jav201.bvbs.util.HibernateConfigBvbs;
import org.hibernate.Session;

import java.util.List;

public class BvbsRepository {
    private Session session = null;

    public BvbsRepository() {
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
}
