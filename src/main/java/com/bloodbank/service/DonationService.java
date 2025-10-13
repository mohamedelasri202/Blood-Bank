package com.bloodbank.service;

import com.bloodbank.dao.DonationDao;
import com.bloodbank.model.BloodDonations;
import com.bloodbank.model.Recipient;

import java.util.Date;

public class DonationService {

    DonationDao donationDao = new DonationDao();

    public void addDonation(Integer donorId, Recipient recipientId){
        BloodDonations donation = new BloodDonations();
        donation.setId(donorId);
        donation.setRecipient(recipientId);
        donation.setQuantity(1.0);
        donation.setDateOfDonation(new Date());

        donationDao.saveDonation(donation);

    }
}
