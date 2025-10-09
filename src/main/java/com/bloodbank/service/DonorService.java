package com.bloodbank.service;

import com.bloodbank.dao.DonorDAO;
import com.bloodbank.model.Donor;

public class DonorService {


    private DonorDAO dao;


    public DonorService() {
        this.dao = new DonorDAO();
    }


    public void addDonor(Donor donor) {
        dao.savedonor(donor);
    }
}
