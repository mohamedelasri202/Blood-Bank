package com.bloodbank.controller;

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
        if (session == null || session.getAttribute("donorBloodType") == null) {
            res.sendRedirect(req.getContextPath() + "/views/error.jsp");
            return;
        }


        BloodType donorType = (BloodType) session.getAttribute("donorBloodType");


        List<Recipient> compatibleRecipients = service.getCompatibleRecipients(donorType);


        req.setAttribute("recipients", compatibleRecipients);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/recipient_list.jsp");
        dispatcher.forward(req, res);
    }
}
