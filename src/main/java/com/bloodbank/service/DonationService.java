package com.bloodbank.service;

import com.bloodbank.dao.DonationDao;
import com.bloodbank.model.BloodDonations;
import com.bloodbank.model.Donor;
import com.bloodbank.model.Recipient;

import java.util.Date;

public class DonationService {

    private DonationDao donationDao = new DonationDao();

    public void addDonation(int donorId, int recipientId) {
        BloodDonations donation = new BloodDonations();

        // Create donor and recipient objects with only IDs set
        Donor donor = new Donor();
        donor.setId(donorId);

        Recipient recipient = new Recipient();
        recipient.setId(recipientId);

        // Set associations
        donation.setDonor(donor);
        donation.setRecipient(recipient);

        // Set default values
        donation.setQuantity(1.0);
        donation.setDateOfDonation(new Date());


        donationDao.saveDonation(donation);

    }
}
