package com.employeeManage.entity;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
public class Address {

    
    @Column(name = "permanent_address")
    private String permanentAddress;

   
    @Column(name = "present_address")
    private String presentAddress;


	public String getPermanentAddress() {
		return permanentAddress;
	}


	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}


	public String getPresentAddress() {
		return presentAddress;
	}


	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
    
    

}
