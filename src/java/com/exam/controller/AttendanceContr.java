/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.controller;

import com.exam.model.Addempolyee;
import com.exam.model.Attendance;
import com.exam.service.AttendanceSirvice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fazly Rabbi
 */
@RestController
@RequestMapping(value = "/")
public class AttendanceContr {
   @Autowired
    AttendanceSirvice attendanceSirvice;
     @RequestMapping(value = "/saveatt", method = RequestMethod.POST)
    public Attendance saveAttendance(@RequestBody Attendance attendance){
        return attendanceSirvice.saveAttendance(attendance);
    }
     @RequestMapping(value = "/showatt", method = RequestMethod.GET)
    public List<Attendance> showAll(){
        return attendanceSirvice.getAll();
    } 
}
