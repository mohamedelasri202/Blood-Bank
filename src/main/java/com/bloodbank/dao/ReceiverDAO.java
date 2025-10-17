package com.bloodbank.dao;

import com.bloodbank.model.AvailabilityStatusRecipient;
import com.bloodbank.model.Recipient;
import com.bloodbank.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ReceiverDAO {

    public void save(Recipient recipient){
        EntityManager em =null;
        EntityTransaction tx = null;
        try {
            em = JPAUtil.getEntityManager();
            tx =em.getTransaction();
            tx.begin();
            em.persist(recipient);
            tx.commit();
        }catch(Exception e){
            if(tx!=null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            if(em!=null){}
            em.close();
        }
    }

    public Recipient getRecipientById(long recipientId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            // No transaction needed for a simple find
            return em.find(Recipient.class, recipientId);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // return null if something goes wrong
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    public Recipient updateRecipientStatus(long recipientId, AvailabilityStatusRecipient status) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Recipient recipient = em.find(Recipient.class, recipientId);

            if (recipient != null) {

                recipient.setAvailability(status);
            }


            tx.commit();

            return recipient;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

}
