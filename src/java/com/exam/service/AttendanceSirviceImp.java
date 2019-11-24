/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.service;

import com.exam.dao.AddempolyeeDao;
import com.exam.dao.AttendanceDao;
import com.exam.model.Attendance;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fazly Rabbi
 */
@Service
@Transactional
public class AttendanceSirviceImp implements AttendanceSirvice{
    @Autowired
    AttendanceDao attendanceDao;
     @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceDao.saveAttendance(attendance);
    }

    @Override
    public List<Attendance> getAll() {
        return attendanceDao.getAll();
    }

    @Override
    public Attendance getById(int id) {
        return attendanceDao.getById(id);
    }
    
}
