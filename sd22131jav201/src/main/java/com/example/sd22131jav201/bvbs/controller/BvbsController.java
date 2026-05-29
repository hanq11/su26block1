package com.example.sd22131jav201.bvbs.controller;

import com.example.sd22131jav201.bvbs.repository.BvbsRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BvbsController", value = {
        "/bac-si/hien-thi" // GET
})
public class BvbsController extends HttpServlet {
    BvbsRepository bvbsRepository = new BvbsRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listBacSi", bvbsRepository.getAll());
        req.getRequestDispatcher("/bvbs/hien-thi.jsp").forward(req, resp);
    }
}
