package com.bloodbank.service;
import com.bloodbank.dao.CompatibilityDao;
import com.bloodbank.model.BloodType;
import com.bloodbank.model.CompatibilityBloodtype;
import com.bloodbank.model.Donor;
import com.bloodbank.model.Recipient;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


  public class MatchingService {
     private final CompatibilityDao dao = new CompatibilityDao();

     public List<Recipient> getCompatibleReceivers(BloodType recipientType){
         List<Recipient> donors = dao.getAllReceivers();


         return donors.stream()
                 .filter(d -> CompatibilityBloodtype.isCompatible(d.getBloodType(), recipientType))
                 .toList();
     }


}
