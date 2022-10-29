package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class EmployeePayrollDTO {
	
	private int id;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name is Invalid")
    @NotEmpty(message = "Employee name cannot be null")
	public String name;
	
	public String profileImage;
	
	@Pattern(regexp = "Male|Female", message = "Gender should be Male or Female")
	public String gender;
	
	@NotNull(message = "Department cannot be Null")
	public String department;
    
	@Min(value = 500, message = "Min salary should be more than 500")
    public long salary;
    
	@JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "startDate cannot be Empty")
    @PastOrPresent(message = "startDate should be past or present date")
    public LocalDate startDate = LocalDate.now();
    
	@NotEmpty(message = "Notes cannot be Empty")
    public String notes;
	
	
}
