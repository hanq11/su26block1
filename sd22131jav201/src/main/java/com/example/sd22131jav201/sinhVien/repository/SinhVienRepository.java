package com.example.sd22131jav201.sinhVien.repository;

import com.example.sd22131jav201.sinhVien.entity.SinhVien;
import com.example.sd22131jav201.sinhVien.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class SinhVienRepository {
    private Session session = null;

    public SinhVienRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<SinhVien> getAll() {
        return session.createQuery("FROM SinhVien sv").list();
    }

//    public static void main(String[] args) {
//        SinhVienRepository sinhVienRepository = new SinhVienRepository();
//        List<SinhVien> danhSach = sinhVienRepository.getAll();
//        danhSach.forEach( sv -> System.out.println(sv.getTen()));
//    }
}
