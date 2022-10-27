package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

@Entity
@Table(name="employee_payroll")
public class EmployeePayrollData {
	
	@Id
	@GeneratedValue
	private int id;
	String name;
	String profileImage;
	String gender;
	String department;
	long salary;
	LocalDate startDate = LocalDate.now();
	String notes;
	
	
	public EmployeePayrollData(EmployeePayrollDTO data) {
		
		this.name = name;
		this.profileImage = profileImage;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
		this.startDate = startDate;
		this.notes = notes;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getProfileImage() {
		return profileImage;
	}


	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public long getSalary() {
		return salary;
	}


	public void setSalary(long salary) {
		this.salary = salary;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	@Override
	public String toString() {
		return "EmployeePayrollData [id=" + id + ", name=" + name + ", profileImage=" + profileImage + ", gender="
				+ gender + ", department=" + department + ", salary=" + salary + ", startDate=" + startDate + ", notes="
				+ notes + "]";
	}

		
	
}
