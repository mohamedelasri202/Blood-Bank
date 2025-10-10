package com.bloodbank.service;
import com.bloodbank.dao.CompatibilityDao;
import com.bloodbank.model.BloodType;
import com.bloodbank.model.CompatibilityBloodtype;
import com.bloodbank.model.Donor;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


  public class MatchingService {
     private final CompatibilityDao dao = new CompatibilityDao();

     public List<Donor> getCompatibleDonors(BloodType recipientType){
         List<Donor> donors = dao.getAllDonors();


         return donors.stream()
                 .filter(d -> CompatibilityBloodtype.isCompatible(d.getBloodtype(), recipientType))
                 .toList();
     }


}
