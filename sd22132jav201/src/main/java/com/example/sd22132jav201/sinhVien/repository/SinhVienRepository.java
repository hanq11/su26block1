package com.example.sd22132jav201.sinhVien.repository;

import com.example.sd22132jav201.sinhVien.entity.SinhVien;
import com.example.sd22132jav201.sinhVien.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class SinhVienRepository {
    private Session session = null;

    public SinhVienRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<SinhVien> getAll() {
        return session.createQuery("FROM SinhVien sv").list(); // JPQL
    }

    public SinhVien getById(Integer id) {
        return session.find(SinhVien.class, id);
    }

    public void themSinhVien(SinhVien sinhVien) {
        try {
            session.getTransaction().begin();
            session.save(sinhVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void suaSinhVien(SinhVien sinhVien) {
        try {
            session.getTransaction().begin();
            session.merge(sinhVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void xoaSinhVien(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getById(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
