package com.bloodbank.controller;

import com.bloodbank.model.BloodDonations;
import com.bloodbank.model.Recipient;
import com.bloodbank.service.DonationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class DonationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int donorId = Integer.parseInt(request.getParameter("donor_id"));
            int recipientId = Integer.parseInt(request.getParameter("receiver_id"));


            DonationService donationService = new DonationService();


            donationService.addDonation(donorId, recipientId);


            response.sendRedirect(request.getContextPath() + "/donation");

        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid donor or recipient ID");
        }
    }





    @Override
    public void doGet(HttpServletRequest req , HttpServletResponse res )  throws  ServletException ,IOException{
        DonationService donationService = new DonationService();
        try {
            List<Object[]> donations = donationService.getAllDonations();
            req.setAttribute("donations",donations);
            req.getRequestDispatcher("views/listDonors.jsp").forward(req,res);
        }catch (Exception e){
            e.printStackTrace();
        }


    }


}
