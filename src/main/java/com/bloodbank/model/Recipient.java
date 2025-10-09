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

    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
    private List<BloodTransfusion> transfusions;




    public String getBloodtype() {
        return bloodtype;
    }

    private String bloodtype;

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
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
