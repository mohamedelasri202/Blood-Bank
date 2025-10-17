package com.bloodbank.dao;

import com.bloodbank.model.BloodDonations;
import com.bloodbank.model.Recipient;
import com.bloodbank.service.DonationService;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import com.bloodbank.util.JPAUtil;
import jakarta.persistence.TypedQuery;


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


    public long countDonationsByRecipientId(int recipientId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(d) FROM BloodDonations d WHERE d.recipient.id = :recipientId",
                    Long.class
            );
            query.setParameter("recipientId", recipientId);
            long count = query.getSingleResult();
            return count;
        } finally {
            em.close();
        }
    }

    public void deleteDonation(int donationId){
        EntityManager em =JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
           tx.begin();
            BloodDonations donations = em.find(BloodDonations.class, donationId);
            if (donations!=null){
                em.remove(donations);
                tx.commit();
            }

        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }


    }

    public BloodDonations getDonationById(int donationsId){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
         BloodDonations donation = null;
        try{
            tx.begin();
            donation = em.find(BloodDonations.class, donationsId);
            return donation;
        }
        finally {
            em.close();
        }

    }
    public BloodDonations updateDonation(BloodDonations donation){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        BloodDonations donations = null;
        try{
            tx.begin();
            donations = em.find(BloodDonations.class, donation.getId());
            em.merge(donations);
            tx.commit();
            return donations;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            em.close();
        }
    }




}
