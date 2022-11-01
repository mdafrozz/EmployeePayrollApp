package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeePayrollDTO {
	
	//private int id;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name is Invalid")
    public String name;
	
	@NotBlank(message = "profilePic cannot be empty" )
	public String profilePic;
	
	@Pattern(regexp = "male|female", message = "Gender should be male or female")
	public String gender;
	
	@NotNull(message = "Department cannot be Null")
	public List<String> department;
    
	@Min(value = 500, message = "Min salary should be more than 500")
    public long salary;

	@JsonFormat(pattern = "dd MM yyyy")
	@NotNull(message = "startDate should Not be Empty")
	@PastOrPresent (message = "startDate should be past or today's date")
    public LocalDate startDate;
    
	@NotBlank(message = "Notes cannot be Empty")
    public String notes;
	
	
}
