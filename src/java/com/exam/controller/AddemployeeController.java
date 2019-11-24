/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.controller;

import com.exam.model.Addempolyee;
import com.exam.model.User;
import com.exam.service.Addempolyservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class AddemployeeController {
    @Autowired
    Addempolyservice addempolyservice;
     @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Addempolyee saveEmployee(@RequestBody Addempolyee addempolyee){
        return addempolyservice.saveEmployee(addempolyee);
    }
     @RequestMapping(value = "/showemp", method = RequestMethod.GET)
    public List<Addempolyee> showAll(){
        return addempolyservice.getAll();
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Addempolyee Update(@RequestBody Addempolyee addempolyee){
         System.out.println("kkkkkkkkkkkkkkkkkkkk");
        return addempolyservice.update(addempolyee);
       
    }
    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public Addempolyee  delete(@PathVariable int id) {
        if(addempolyservice.delete(id)){
            return new Addempolyee();
        }else{
            return null;
        }
        
    }

}
