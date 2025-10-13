package com.bloodbank.dao;

import com.bloodbank.model.BloodDonations;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import com.bloodbank.util.JPAUtil;


public class DonationDao {

    public void saveDonation(BloodDonations donation){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(donation);
            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }

    }
}
