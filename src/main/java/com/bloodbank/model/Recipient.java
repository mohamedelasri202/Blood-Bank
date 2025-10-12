package com.bloodbank.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String lastname;
    private String phone;
    private String cin;
    private String dateOfBirth;
    private String gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "urgency")
    private UrgencyLevel urgency;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_type")
    private BloodType bloodType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AvailabilityStatusRecipient availability;

    // ✅ One recipient can receive many donations
    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BloodDonations> donations;

    // ✅ One recipient can have multiple transfusions
    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BloodTransfusion> transfusions;

    // ---------- Getters and Setters ----------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String c() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UrgencyLevel getUrgency() {
        return urgency;
    }

    public void setUrgency(UrgencyLevel urgency) {
        this.urgency = urgency;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public AvailabilityStatusRecipient getAvailability() {
        return availability;
    }

    public void setAvailability(AvailabilityStatusRecipient availability) {
        this.availability = availability;
    }

    public List<BloodDonations> getDonations() {
        return donations;
    }

    public void setDonations(List<BloodDonations> donations) {
        this.donations = donations;
    }

    public List<BloodTransfusion> getTransfusions() {
        return transfusions;
    }

    public void setTransfusions(List<BloodTransfusion> transfusions) {
        this.transfusions = transfusions;
    }
}
