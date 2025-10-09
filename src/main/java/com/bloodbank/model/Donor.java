package com.bloodbank.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name ;
    private String lastname;
    private String phone;
    private String Cin;
    private String dateofbirth;
    private double weith;
    private String gender;
    @Enumerated(EnumType.STRING)
    @Column(name ="blood_type")
    private BloodType bloodtype;
    @Enumerated(EnumType.STRING)
    @Column(name ="status")
    private AvailabilityStatus status;

    public Donor(){
        this.status=AvailabilityStatus.AVAILABLE;
    }

    @OneToMany(mappedBy = "donor" ,cascade = CascadeType.ALL)
    private List<BloodDonations> donations;

    public List<BloodDonations> getDonations() {
        return donations;
    }

    public void setDonations(List<BloodDonations> donations) {
        this.donations = donations;
    }

    public int getId() {
        return id;
    }

    public void setBloodtype(BloodType bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCin() {
        return Cin;
    }

    public double getWeith() {
        return weith;
    }

    public BloodType getBloodtype() {
        return bloodtype;
    }

    public void setStatus(AvailabilityStatus status) {
        this.status = status;
    }

    public AvailabilityStatus getStatus() {
        return status;
    }

    public String getGender() {
        return gender;
    }

    public String getDateofbirth() {
        return dateofbirth;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCin(String cin) {
        Cin = cin;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public void setWeith(double weith) {
        this.weith = weith;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
