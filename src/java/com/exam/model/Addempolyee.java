/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author farid
 */
@Entity
public class Addempolyee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int issueId;
    private String name;
    private String email;
    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identifiedByUserId")
    User identifiedByUserId;*/
   // @Temporal(TemporalType.TIMESTAMP)
    private String identifiedDate;
     private String salary;
     private String address;
    
    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "relatedProjectId")
    ItProject project;*/
    
    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assignedToUserId")
    User assignedToUserId;
    
    String status;
    String priority;
    @Temporal(TemporalType.TIMESTAMP)
    Date targetResolutionDate;
    String progress;
    @Temporal(TemporalType.TIMESTAMP)
    Date actualResolutionDate;
    String resolutionSummery;
    @Temporal(TemporalType.DATE)
    private Date createdOn;
    private String createBy;
    @Temporal(TemporalType.DATE)
    private Date modifiedOn;
    private String modifiedBy;*/
    private String jobTitel;

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public String getJobTitel() {
        return jobTitel;
    }

    public void setJobTitel(String jobTitel) {
        this.jobTitel = jobTitel;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    

    @Override
    public String toString() {
        return "Addempolyee{" + "issueId=" + issueId + ", name=" + name + ", email=" + email + ", identifiedDate=" + identifiedDate + ", salary=" + salary + ", address=" + address + ", jobTitel=" + jobTitel + '}';
    }

    public String getIdentifiedDate() {
        return identifiedDate;
    }

    public void setIdentifiedDate(String identifiedDate) {
        this.identifiedDate = identifiedDate;
    }

   

    
    
}
