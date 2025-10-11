package com.bloodbank.dao;

import com.bloodbank.model.Donor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bloodbank.util.JPAUtil;

import java.util.List;

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




}
