package com.bloodbank.controller;

import com.bloodbank.model.AvailabilityStatus;
import com.bloodbank.model.BloodType;
import com.bloodbank.model.Donor;
import com.bloodbank.service.DonorService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.core.Response;

import java.util.List;

import java.io.IOException;

public class DonorServlet extends HttpServlet {
    private DonorService donorservice = new DonorService();


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null) {
            Integer donorId = (Integer) session.getAttribute("donorId");
            if (donorId != null) {

                Donor donor = donorservice.getDonor(donorId);
                request.setAttribute("donor", donor);
            }
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("donorForm");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
        HttpSession session = request.getSession();

        try {

            String name = request.getParameter("name");
            String lastname = request.getParameter("lastname");
            String phone = request.getParameter("phone");
            String cin = request.getParameter("cin");
            String dateOfBirth = request.getParameter("dateofbirth");
            double weight = Double.parseDouble(request.getParameter("weight"));
            String gender = request.getParameter("gender");
            BloodType bloodType = BloodType.valueOf(request.getParameter("bloodtype"));


            Donor donor = new Donor();
            donor.setName(name);
            donor.setLastname(lastname);
            donor.setPhone(phone);
            donor.setCin(cin);
            donor.setDateofbirth(dateOfBirth);
            donor.setWeith(weight);
            donor.setGender(gender);
            donor.setBloodtype(bloodType);

            if (donor.getWeith() < 50) {

                response.sendRedirect(request.getContextPath() + "/views/Eligibility.jsp");
                return;
            }


            String statusParam = request.getParameter("status");
            if (statusParam != null && !statusParam.isEmpty()) {
                donor.setStatus(AvailabilityStatus.valueOf(statusParam));
            }



           Donor savedDonor= donorservice.addDonor(donor);
            BloodType bloodtype = savedDonor.getBloodtype();

            session.setAttribute("donorBloodtype", bloodtype);
            session.setAttribute("donorId", savedDonor.getId());
            session.setAttribute("donorStatus", savedDonor.getStatus());




            response.sendRedirect(request.getContextPath() + "/matching");


        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error saving donor: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }




}
