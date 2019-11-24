/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.dao;

import com.exam.model.Addempolyee;
import com.exam.model.Attendance;
import java.util.List;

/**
 *
 * @author Fazly Rabbi
 */
public interface AttendanceDao {
    public Attendance saveAttendance(Attendance attendance);
    public List<Attendance> getAll();
    public Attendance getById(int id);

}
