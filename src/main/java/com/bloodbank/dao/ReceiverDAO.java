package com.bloodbank.dao;

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
}
