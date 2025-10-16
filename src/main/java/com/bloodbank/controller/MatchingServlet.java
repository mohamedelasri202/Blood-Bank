package com.bloodbank.controller;

import com.bloodbank.model.AvailabilityStatus;
import com.bloodbank.model.BloodType;
import com.bloodbank.model.Recipient;
import com.bloodbank.service.MatchingService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class MatchingServlet extends HttpServlet {
    private final MatchingService service = new MatchingService();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null) {
            res.sendRedirect(req.getContextPath() + "/donorForm");
            return;
        }


        Integer donorId = (Integer) session.getAttribute("donorId");
        BloodType donorBloodType = (BloodType) session.getAttribute("donorBloodtype");



        if (donorId == null || donorBloodType == null) {
            res.sendRedirect(req.getContextPath() + "/donorForm");
            return;
        }


        List<Recipient> compatibleReceivers = service.getCompatibleReceivers(donorBloodType);


        req.setAttribute("donorId", donorId);
        req.setAttribute("receivers", compatibleReceivers);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/donor_lists.jsp");
        dispatcher.forward(req, res);
    }



}
