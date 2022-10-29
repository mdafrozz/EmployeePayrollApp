package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import lombok.Data;

@Entity
@Table(name="employee_payroll")
@Data
public class EmployeePayrollData {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String profileImage;
	private String gender;
	private String department;
	private long salary;
	private LocalDate startDate = LocalDate.now();
	private String notes;
	
	
	
	public EmployeePayrollData() {
	
	}

	public EmployeePayrollData(EmployeePayrollDTO dto) {
	       
	        this.update(dto);
    }

    public void update(EmployeePayrollDTO dto) {
	        this.name = dto.name;
	        this.salary = dto.salary;
	        this.gender = dto.gender;
	        this.notes = dto.notes;
	        this.startDate = dto.startDate;
	        this.profileImage = dto.profileImage;
	        this.department = dto.department;
	 }
	
}
