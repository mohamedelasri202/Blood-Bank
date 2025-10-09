package com.bloodbank.controller;

import com.bloodbank.service.DonorService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DonorServlet extends HttpServlet {
    private DonorService donorservice = new DonorService();


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/donorForm.jsp");
        dispatcher.forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String bloodType = req.getParameter("bloodType");
        int age = Integer.parseInt(req.getParameter("age"));

        donorservice.registerDonor(name, bloodType, age);

        resp.sendRedirect(req.getContextPath() + "/donors/list");
    }


}
