package com.bloodbank.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recipient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name ;
    private String lastname;
    private String phone;
    private String Cin ;
    private String dateOfbirth;
    private String gender;
    @Enumerated(EnumType.STRING)
    @Column(name = "urgency")
    private UrgencyLevel urgency;

    public void setAvailability(AvailabilityStatusRecipient availability) {
        this.availability = availability;
    }

    public AvailabilityStatusRecipient getAvailability() {
        return availability;
    }

    @Enumerated(EnumType.STRING)
    @Column(name ="blood_type")
    private BloodType bloodType;
    @Enumerated(EnumType.STRING)
    @Column(name = "Status")

    private AvailabilityStatusRecipient availability;

    public void setUrgency(UrgencyLevel urgency) {
        this.urgency = urgency;
    }

    public UrgencyLevel getUrgency() {
        return urgency;
    }

    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
    private List<BloodTransfusion> transfusions;


    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public void setTransfusions(List<BloodTransfusion> transfusions) {
        this.transfusions = transfusions;
    }

    public List<BloodTransfusion> getTransfusions() {
        return transfusions;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCin(String cin) {
        Cin = cin;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDateOfbirth(String dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getCin() {
        return Cin;
    }

    public String getDateOfbirth() {
        return dateOfbirth;
    }

    public String getGender() {
        return gender;
    }

}
