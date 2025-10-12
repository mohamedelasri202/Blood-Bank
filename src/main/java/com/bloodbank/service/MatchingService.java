package com.bloodbank.service;

import com.bloodbank.dao.CompatibilityDao;
import com.bloodbank.model.BloodType;
import com.bloodbank.model.CompatibilityBloodtype;
import com.bloodbank.model.Recipient;

import java.util.List;

public class MatchingService {
    private final CompatibilityDao dao = new CompatibilityDao();

    public List<Recipient> getCompatibleRecipients(BloodType donorType) {
        List<Recipient> recipients = dao.getAllReceivers();


        return recipients.stream()
                .filter(r -> CompatibilityBloodtype.isCompatible(donorType, r.getBloodType()))
                .toList();
    }
}
