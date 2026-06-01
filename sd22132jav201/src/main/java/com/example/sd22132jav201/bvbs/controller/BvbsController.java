package com.example.sd22132jav201.bvbs.controller;

import com.example.sd22132jav201.bvbs.entity.BacSi;
import com.example.sd22132jav201.bvbs.entity.BenhVien;
import com.example.sd22132jav201.bvbs.repository.BacSiRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BvbsController", value = {
        "/bac-si/hien-thi", // GET
        "/bac-si/view-update", // GET
        "/bac-si/them", // POST
        "/bac-si/sua", // POST
        "/bac-si/xoa" // GET
})
public class BvbsController extends HttpServlet {
    BacSiRepository bacSiRepository = new BacSiRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listBacSi", bacSiRepository.getAll());
        req.setAttribute("listBenhVien", bacSiRepository.getAllBenhVien());
        req.getRequestDispatcher("/bvbs/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("them")) {
            themBacSi(req, resp);
        }
    }

    private void themBacSi(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenBacSi = req.getParameter("tenBacSi");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        Integer idBenhVien = Integer.valueOf(req.getParameter("benhVien"));
        BenhVien benhVien = bacSiRepository.getBenhVienById(idBenhVien);

        BacSi bacSi = new BacSi(null, tenBacSi, tuoi, gioiTinh, benhVien);
        bacSiRepository.themBacSi(bacSi);
        resp.sendRedirect("/bac-si/hien-thi");
    }
}
