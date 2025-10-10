package com.bloodbank.service;

import com.bloodbank.dao.ReceiverDAO;
import com.bloodbank.model.Recipient;

public class ReceiverService {


    ReceiverDAO receiverDAO ;

    public ReceiverService(){
        this.receiverDAO = new ReceiverDAO();

    }

    public void addRecipient(Recipient recipient){
        receiverDAO.save(recipient);
    }
}
