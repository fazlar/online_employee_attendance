/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.dao;

import com.exam.model.Addempolyee;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Student
 */
@Repository
public class AddempolyeeDaoImp implements AddempolyeeDao{
 @Autowired
    SessionFactory sessionFactory;
 
    @Override
    public Addempolyee saveEmployee(Addempolyee addempolyee) {
       
         sessionFactory.getCurrentSession().save(addempolyee);
        return addempolyee;
        
    }

    @Override
    public List<Addempolyee> getAll() {
         List<Addempolyee> userList = (List<Addempolyee>) sessionFactory.getCurrentSession()
                .createQuery("From Addempolyee").list();
        return userList;
    }

    @Override
    public Addempolyee getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Addempolyee update(Addempolyee addempolyee) {
        sessionFactory.getCurrentSession().saveOrUpdate(addempolyee);
        return addempolyee;
    }

    @Override
    public boolean delete(int id) {
 Addempolyee entity = (Addempolyee) sessionFactory.getCurrentSession().get(Addempolyee.class, id);
        sessionFactory.getCurrentSession()
                .delete(entity);
        return true;    }
    
}
