package com.bloodbank.dao;

import com.bloodbank.model.BloodType;
import com.bloodbank.model.Donor;
import com.bloodbank.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CompatibilityDao {

    public List<Donor> getAllDonors() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT d FROM Donor d", Donor.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        } finally {
            em.close();
        }
    }

}
