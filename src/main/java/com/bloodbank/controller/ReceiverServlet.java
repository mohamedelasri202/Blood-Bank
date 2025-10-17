package com.bloodbank.controller;

import com.bloodbank.model.AvailabilityStatusRecipient;
import com.bloodbank.model.BloodType;
import com.bloodbank.model.Recipient;
import com.bloodbank.model.UrgencyLevel;
import com.bloodbank.service.ReceiverService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ReceiverServlet extends HttpServlet {

    private ReceiverService receiverService = new ReceiverService();

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{

        RequestDispatcher dispatcher = req.getRequestDispatcher("receiverForm");
        dispatcher.forward(req ,resp);
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
        try {
            String name = req.getParameter("name");
            String lastname = req.getParameter("lastname");
            String phone = req.getParameter("phone");
            String cin = req.getParameter("cin");
            String dateofbirth =req.getParameter("date_of_birth");
            String gender = req.getParameter("gender");
            BloodType bloodtype = BloodType.valueOf(req.getParameter("bloodtype"));
//            String emergencystatus =req.getParameter("emergencystatus");

            UrgencyLevel urgencylevel = UrgencyLevel.valueOf(req.getParameter("urgency"));

            Recipient recipient = new Recipient();
            recipient.setName(name);
            recipient.setLastname(lastname);
            recipient.setPhone(phone);
            recipient.setCin(cin);
            recipient.setGender(gender);
            recipient.setBloodType(bloodtype);
            recipient.setDateOfBirth(dateofbirth);
            recipient.setUrgency(urgencylevel);
            recipient.setAvailability(AvailabilityStatusRecipient.ON_HOLD);
        receiverService.addRecipient( recipient);
       resp.sendRedirect(req.getContextPath() + "/donation?view=receivers");
        }catch(Exception e){
            e.printStackTrace();
            req.setAttribute("error","error");
            req.getRequestDispatcher("receiverForm").forward(req,resp);
        }




    }



}
