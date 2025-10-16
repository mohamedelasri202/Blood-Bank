package com.bloodbank.service;

import com.bloodbank.dao.DonorDAO;
import com.bloodbank.model.AvailabilityStatus;
import com.bloodbank.model.Donor;

public class DonorService {


    private DonorDAO dao;


    public DonorService() {
        this.dao = new DonorDAO();
    }


    public Donor addDonor(Donor donor) {
        dao.savedonor(donor);
        return donor;
    }

    public Donor getDonor(int id){
        return dao.findById(id);
    }

    public  void updateDonorStatus(int  donorId , AvailabilityStatus newStatus) {
         dao.updateDonorStatus(donorId ,newStatus);
    }
}
