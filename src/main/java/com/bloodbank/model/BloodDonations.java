package com.bloodbank.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity


public class BloodDonations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private Donor donor;
    @ManyToOne
    @JoinColumn
    private  Recipient recipient;



    private double quantity;
    private Date dateOfDonation;

    public int getId() {
        return id;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public Donor getDonor() {
        return donor;
    }

    public double getQuantity() {
        return quantity;
    }

    public Date getDateOfDonation() {

        return dateOfDonation;
    }

    public void setDonor(Donor donor) {

        this.donor = donor;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setDateOfDonation(Date dateOfDonation) {
        this.dateOfDonation = dateOfDonation;
    }
}
