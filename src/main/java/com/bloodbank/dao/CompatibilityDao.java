package com.bloodbank.dao;

import com.bloodbank.model.Recipient;
import com.bloodbank.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CompatibilityDao {

    public List<Recipient> getAllReceivers() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT r FROM Recipient  r", Recipient.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        } finally {
            em.close();
        }
    }
}
