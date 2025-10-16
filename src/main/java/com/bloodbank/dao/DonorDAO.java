package com.bloodbank.dao;

import com.bloodbank.model.AvailabilityStatus;
import com.bloodbank.model.Donor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import com.bloodbank.util.JPAUtil;

public class DonorDAO {

    public void savedonor(Donor donor){
        EntityManager em = null;
        EntityTransaction tx =null;
        try{
            em = JPAUtil.getEntityManager();
            tx=em.getTransaction();
            tx.begin();
            em.persist(donor);
            tx.commit();
        }catch(Exception e){
             if(tx!=null && tx.isActive()){
                 tx.rollback();
             }
             e.printStackTrace();
        }finally{
            if(em!=null){
                em.close();
            }
        }


    }


    public Donor findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Donor donor = null;
        try {
            donor = em.find(Donor.class, id);
        } finally {
            em.close();
        }
        return donor;
    }

    public void  updateDonorStatus(int donorId, AvailabilityStatus newStatus) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Donor donor = em.find(Donor.class, donorId);
            if(donor!=null){
                donor.setStatus(newStatus);
            }
            tx.commit();

        }catch (Exception e){
            if(tx!=null && tx.isActive()){
                tx.rollback();
            }

        }finally{
            em.close();
        }


    }




}
