package com.bloodbank.service;

import com.bloodbank.dao.CompatibilityDao;
import com.bloodbank.model.BloodType;
import com.bloodbank.model.CompatibilityBloodtype;
import com.bloodbank.model.Recipient;

import java.util.Comparator;
import java.util.List;

public class MatchingService {
    private final CompatibilityDao dao = new CompatibilityDao();

    public List<Recipient> getCompatibleReceivers(BloodType donorType) {
        List<Recipient> recipients = dao.getAllReceivers();
        return recipients.stream()
                .filter(r -> CompatibilityBloodtype.isCompatible(donorType, r.getBloodType()))
                .sorted(Comparator.comparingInt(r -> switch (r.getUrgency()) {
                    case CRITICAL -> 1;
                    case URGENT   -> 2;
                    case NORMAL   -> 3;
                }))
                .toList();
    }



}
