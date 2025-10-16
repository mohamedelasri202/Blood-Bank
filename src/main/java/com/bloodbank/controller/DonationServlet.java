        package com.bloodbank.controller;

        import com.bloodbank.model.AvailabilityStatus;
        import com.bloodbank.model.AvailabilityStatusRecipient;
        import com.bloodbank.model.BloodDonations;
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


            @Override
            protected void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {

                try {
                    int donorId = Integer.parseInt(request.getParameter("donor_id"));
                    int recipientId = Integer.parseInt(request.getParameter("receiver_id"));

                    DonationService donationService = new DonationService();
                    DonorService donorService = new DonorService();
                    ReceiverService recipientService = new ReceiverService();

                    donationService.addDonation(donorId, recipientId);


                    donorService.updateDonorStatus(donorId, AvailabilityStatus.NOT_AVAILABLE);
                    HttpSession session = request.getSession();
                    session.setAttribute("donorStatus", AvailabilityStatus.NOT_AVAILABLE);


                    long count = donationService.countDonationsByRecipientId(recipientId);


                    Recipient recipient = recipientService.getRecipientById(recipientId);


                    int requiredDonations = switch (recipient.getUrgency()) {
                        case CRITICAL -> 4;
                        case URGENT   -> 3;
                        case NORMAL   -> 1;
                    };


                    if (count >= requiredDonations) {
                        recipientService.updateRecipientStatus(recipientId, AvailabilityStatusRecipient.SATISFIED);
                    }


                    response.sendRedirect(request.getContextPath() + "/donation");

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid donor or recipient ID");
                }
            }







            @Override
            public void doGet(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException {
                DonationService donationService = new DonationService();

                try {

                    List<Object[]> allDetails = donationService.getAllDonations();


                    String view = req.getParameter("view");
                    if (view == null) view = "donors";

                    if (view.equals("donors")) {
                        // Filter or process data for donors view
                        List<Object[]> donorList = allDetails.stream()
                                .filter(row -> row[0] != null)
                                .toList();

                        req.setAttribute("donations", donorList);
                        req.getRequestDispatcher("views/listDonors.jsp").forward(req, res);

                    } else if (view.equals("receivers")) {

                        List<Object[]> receiverList = allDetails.stream()
                                .filter(row -> row[1] != null)
                                .toList();

                        req.setAttribute("donations", receiverList);
                        req.getRequestDispatcher("views/listReceivers.jsp").forward(req, res);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }



        }
