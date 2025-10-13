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

   public  void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       try {
           Integer donorId = Integer.parseInt(request.getParameter("donorId"));
           Recipient recipientId = Integer.parseInt(request.getParameter("recipientId"));
           DonationService donationService = new DonationService();

           donationService.addDonation(donorId ,recipientId);



       }catch (NumberFormatException e){

       }
   }
}
