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

import java.io.IOException;

public class DonorServlet extends HttpServlet {
    private DonorService donorservice = new DonorService();


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
       throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("donorForm");
        dispatcher.forward(req, resp);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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


            String statusParam = request.getParameter("status");
            if (statusParam != null && !statusParam.isEmpty()) {
                donor.setStatus(AvailabilityStatus.valueOf(statusParam));
            }

            donorservice.addDonor(donor);

            response.sendRedirect(request.getContextPath() + "/donors/listDonors.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error saving donor: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }


}
