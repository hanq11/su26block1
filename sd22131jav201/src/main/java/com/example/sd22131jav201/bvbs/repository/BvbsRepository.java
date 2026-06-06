package com.example.sd22131jav201.bvbs.repository;

import com.example.sd22131jav201.bvbs.entity.BacSi;
import com.example.sd22131jav201.bvbs.entity.BenhVien;
import com.example.sd22131jav201.bvbs.util.HibernateConfigBvbs;
import org.hibernate.Session;
import org.hibernate.query.Query;

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

    public BacSi getById(Integer id) {
        return session.find(BacSi.class, id);
    }

    public void suaBacSi(BacSi bacSi) {
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
            session.delete(this.getById(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public List<BacSi> timKiemTheoTen(String tenTimKiem) {
        Query query = session.createQuery("FROM BacSi bs WHERE bs.tenBacSi LIKE :tenTimKiem");
        query.setParameter("tenTimKiem", "%" + tenTimKiem + "%");
        return query.list();
    }

    public List<BacSi> phanTrang(int page, int pageSize) {
        Query query = session.createQuery("FROM BacSi bs");
        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);
        return query.list();
    }
}
