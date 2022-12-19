package com.springapp.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
public class EmployeeCrud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int EMPLOYEE_NUMBER;

	@Size(min=3, max=30)
	private String EMPLOYEE_NAME;
	
	private int SALARY;

	public int getEMPLOYEE_NUMBER() {
		return this.EMPLOYEE_NUMBER;
	}

	public void setEMPLOYEE_NUMBER(int EMPLOYEE_NUMBER ) {
		this.EMPLOYEE_NUMBER = EMPLOYEE_NUMBER;
	}
 
	public String getEMPLOYEE_NAME() {
		return this.EMPLOYEE_NAME;
	}
	
	public void setEMPLOYEE_NAME(String EMPLOYEE_NAME) {
		this.EMPLOYEE_NAME = EMPLOYEE_NAME;
	}
	public int getSALARY() {
		return this.SALARY;
	}

	public void setSALARY(int SALARY) {
		this.SALARY = SALARY;
	}	

}
