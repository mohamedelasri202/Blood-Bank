package com.bloodbank.dao;

import com.bloodbank.model.BloodDonations;
import com.bloodbank.service.DonationService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import com.bloodbank.util.JPAUtil;
import jakarta.persistence.TypedQuery;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;


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
    public List<Object[]> getAllDonationDetails() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Object[]> query = em.createQuery(
                    "SELECT d, r, bd " +
                            "FROM BloodDonations bd " +
                            "JOIN bd.donor d " +
                            "JOIN bd.recipient r",
                    Object[].class
            );
            return query.getResultList();
        } finally {
            em.close();
        }
    }




}
