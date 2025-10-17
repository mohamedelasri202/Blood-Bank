package com.bloodbank.controller;

import com.bloodbank.model.AvailabilityStatus;
import com.bloodbank.model.AvailabilityStatusRecipient;
import com.bloodbank.model.Recipient;
import com.bloodbank.service.DonationService;
import com.bloodbank.service.DonorService;
import com.bloodbank.service.ReceiverService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class DonationServlet extends HttpServlet {

    private DonationService donationService = new DonationService();
    private DonorService donorService = new DonorService();
    private ReceiverService recipientService = new ReceiverService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "add";

        try {
            switch (action) {
                case "add":
                    addDonation(request, response);
                    break;
                case "delete":
                    deleteDonation(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/donation");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            List<Object[]> allDetails = donationService.getAllDonations();

            String view = req.getParameter("view");
            if (view == null) view = "donors";

            if (view.equals("donors")) {
                List<Object[]> donorList = allDetails.stream()
                        .filter(row -> row[0] != null)
                        .toList();
                req.setAttribute("donations", donorList);
                req.getRequestDispatcher("/views/listDonors.jsp").forward(req, res);

            } else if (view.equals("receivers")) {
                List<Object[]> receiverList = allDetails.stream()
                        .filter(row -> row[1] != null)
                        .toList();
                req.setAttribute("donations", receiverList);
                req.getRequestDispatcher("/views/listReceivers.jsp").forward(req, res);
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error loading donations");
        }
    }
    private void addDonation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int donorId = Integer.parseInt(request.getParameter("donor_id"));
        int recipientId = Integer.parseInt(request.getParameter("receiver_id"));

        donationService.addDonation(donorId, recipientId);

        donorService.updateDonorStatus(donorId, AvailabilityStatus.NOT_AVAILABLE);
        HttpSession session = request.getSession();
        session.setAttribute("donorStatus", AvailabilityStatus.NOT_AVAILABLE);

        long count = donationService.countDonationsByRecipientId(recipientId);
        Recipient recipient = recipientService.getRecipientById(recipientId);

        int requiredDonations = switch (recipient.getUrgency()) {
            case CRITICAL -> 4;
            case URGENT -> 3;
            case NORMAL -> 1;
        };

        if (count >= requiredDonations) {
            recipientService.updateRecipientStatus(recipientId, AvailabilityStatusRecipient.SATISFIED);
        }

        response.sendRedirect(request.getContextPath() + "/donation");
    }

    private void deleteDonation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int donationId = Integer.parseInt(request.getParameter("donation_id"));
        donationService.deleteDonation(donationId);
        response.sendRedirect(request.getContextPath() + "/donation");
    }
}
