package com.bloodbank.controller;


import com.bloodbank.model.BloodType;
import com.bloodbank.model.CompatibilityBloodtype;
import com.bloodbank.model.Donor;
import com.bloodbank.model.Recipient;
import com.bloodbank.service.MatchingService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MatchingServlet extends HttpServlet {
    private final MatchingService service = new MatchingService();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String bloodTypeParam = req.getParameter("bloodType");
        BloodType recipientType = BloodType.valueOf(bloodTypeParam);

        List<Recipient> compatibleDonors = service.getCompatibleReceivers(recipientType);


        req.setAttribute("donors", compatibleDonors);


        RequestDispatcher dispatcher = req.getRequestDispatcher("views/donor_lists.jsp");
        dispatcher.forward(req, res);

    }

}
