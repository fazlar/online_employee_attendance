/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.service;

import com.exam.dao.AddempolyeeDao;
import com.exam.model.Addempolyee;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Student
 */
@Service
@Transactional
public class AddempolyserviceImp implements Addempolyservice{
    @Autowired
    AddempolyeeDao addempolyeeDao;
    @Override
    public Addempolyee saveEmployee(Addempolyee addempolyee) {
        return addempolyeeDao.saveEmployee(addempolyee);
    }

    @Override
    public List<Addempolyee> getAll() {
        return  addempolyeeDao.getAll();
    }

    @Override
    public Addempolyee getById(int id) {
        return  addempolyeeDao.getById(id);
    }

    @Override
    public Addempolyee update(Addempolyee addempolyee) {
       return addempolyeeDao.update(addempolyee);
    }

    @Override
    public boolean delete(int id) {
    return addempolyeeDao.delete(id);    
    }
    
}
