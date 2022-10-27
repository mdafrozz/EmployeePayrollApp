package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;

public class EmployeePayrollDTO {
	
	String name;
	String profileImage;
	String gender;
	String department;
	long salary;
	LocalDate startDate = LocalDate.now();
	String notes;
	
	public EmployeePayrollDTO(String name, String profileImage, String gender, String department, long salary,
			LocalDate startDate, String notes) {
		super();
		this.name = name;
		this.profileImage = profileImage;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
		this.startDate = startDate;
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO [name=" + name + ", profileImage=" + profileImage + ", gender=" + gender
				+ ", department=" + department + ", salary=" + salary + ", startDate=" + startDate + ", notes=" + notes
				+ "]";
	}

	public EmployeePayrollDTO() {
		super();
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
	
	
}
