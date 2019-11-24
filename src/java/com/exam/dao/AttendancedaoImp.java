/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.dao;

import com.exam.model.Addempolyee;
import com.exam.model.Attendance;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fazly Rabbi
 */
@Repository
public class AttendancedaoImp implements AttendanceDao{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Attendance saveAttendance(Attendance attendance) {
      sessionFactory.getCurrentSession().save(attendance);
          return  attendance;
             }

    @Override
    public List<Attendance> getAll() {
       List<Attendance> userList = (List<Attendance>) sessionFactory.getCurrentSession()
                .createQuery("From Attendance").list();
        return userList;
    }

    @Override
    public Attendance getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
