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

//    public static void main(String[] args) {
//        SinhVienRepository svrp = new SinhVienRepository();
//        List<SinhVien> danhSach = svrp.getAll();
//        danhSach.forEach( sv -> System.out.println(sv.getTen()));
//    }
}
