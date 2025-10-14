package com.bloodbank.controller;

import com.bloodbank.model.BloodDonations;
import com.bloodbank.model.Recipient;
import com.bloodbank.service.DonationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DonationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int donorId = Integer.parseInt(request.getParameter("donor_id"));
            int recipientId = Integer.parseInt(request.getParameter("receiver_id"));

            // Create the service
            DonationService donationService = new DonationService();


            donationService.addDonation(donorId, recipientId);

            // Redirect or show success message
            response.sendRedirect("views/listDonors.jsp");

        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid donor or recipient ID");
        }
    }
}
