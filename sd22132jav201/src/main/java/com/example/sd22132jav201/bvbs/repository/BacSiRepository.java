package com.example.sd22132jav201.bvbs.repository;

import com.example.sd22132jav201.bvbs.entity.BacSi;
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
}
