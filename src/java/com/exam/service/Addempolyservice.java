/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.service;


import com.exam.model.Addempolyee;
import java.util.List;

/**
 *
 * @author Student
 */
public interface Addempolyservice {
    public Addempolyee saveEmployee(Addempolyee addempolyee);
    public Addempolyee update(Addempolyee addempolyee);
      public boolean delete(int id);
    public List<Addempolyee> getAll();
    public Addempolyee getById(int id);
}
