package com.bloodbank.service;

import com.bloodbank.dao.DonationDao;
import com.bloodbank.dao.DonorDAO;
import com.bloodbank.model.BloodDonations;
import com.bloodbank.model.Donor;
import com.bloodbank.model.Recipient;

import java.util.Date;
import java.util.List;

public class DonationService {

    private DonationDao donationDao = new DonationDao();

    public void addDonation(int donorId, int recipientId) {
        BloodDonations donation = new BloodDonations();


        Donor donor = new Donor();
        donor.setId(donorId);

        Recipient recipient = new Recipient();
        recipient.setId(recipientId);


        donation.setDonor(donor);
        donation.setRecipient(recipient);


        donation.setQuantity(1.0);
        donation.setDateOfDonation(new Date());


        donationDao.saveDonation(donation);

    }

    public List<Object[]> getAllDonations() {
       return  donationDao.getAllDonationDetails();

    }

    public long countDonationsByRecipientId(int recipientId) {
        return  donationDao.countDonationsByRecipientId(recipientId);
    }

    public void deleteDonation(int donationId) {
        donationDao.deleteDonation(donationId);
    }

    public  BloodDonations getDonationById(int donationId) {
       return donationDao.getDonationById(donationId);
    }

//    public BloodDonations getDonationByDonationId(BloodDonations donationId) {
//      return   donationDao.updateDonation(donationId);
//    }


}
