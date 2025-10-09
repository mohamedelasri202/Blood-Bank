package com.bloodbank.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class BloodTransfusion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private Recipient recipient;

    private double quantity;
    private Date dateOfTransfusion;

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Recipient getRecipient() {
        return recipient;
    }
    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Date getDateOfTransfusion() {
        return dateOfTransfusion;
    }
    public void setDateOfTransfusion(Date dateOfTransfusion) {
        this.dateOfTransfusion = dateOfTransfusion;
    }
}
