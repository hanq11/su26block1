package com.example.sd22131jav201.sinhVien.controller;

import com.example.sd22131jav201.sinhVien.repository.SinhVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SinhVienController", value = {
        "/sinh-vien/hien-thi", // GET
        "/sinh-vien/view-update", // GET
        "/sinh-vien/them", // POST
        "/sinh-vien/sua", // POST
        "/sinh-vien/xoa" // GET
})
public class SinhVienController extends HttpServlet {
    SinhVienRepository sinhVienRepository = new SinhVienRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSinhVien", sinhVienRepository.getAll());
        req.getRequestDispatcher("/sinhVien/hien-thi.jsp").forward(req, resp);
    }
}
