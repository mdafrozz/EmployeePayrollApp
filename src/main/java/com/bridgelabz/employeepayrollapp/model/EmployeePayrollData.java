package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="employee_payroll")
@NoArgsConstructor
public class EmployeePayrollData {
	
	@Id
	@GeneratedValue
	@Column(name = "employee_id")
	private int employeeId;
	
	private String name;
	private String profilePic;
	private String gender;
	private long salary;
	private LocalDate startDate;
	private String notes;
	
	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name="id"))
	private List<String> department;
	
	public EmployeePayrollData(EmployeePayrollDTO dto) {
	       //this.employeeId = employeeId;
		this.name = dto.name;
        this.salary = dto.salary;
        this.gender = dto.gender;
        this.notes = dto.notes;
        this.startDate = dto.startDate;
        this.profilePic = dto.profilePic;
        this.department = dto.department;
    }

    public void update(EmployeePayrollDTO dto) {
	        this.name = dto.name;
	        this.salary = dto.salary;
	        this.gender = dto.gender;
	        this.notes = dto.notes;
	        this.startDate = dto.startDate;
	        this.profilePic = dto.profilePic;
	        this.department = dto.department;
	 }
	
}
