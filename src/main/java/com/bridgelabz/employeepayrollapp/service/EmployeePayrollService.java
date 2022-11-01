package com.bridgelabz.employeepayrollapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	
	@Autowired
    EmployeePayrollRepository repo;
	

	public String getmessage() {
        return "Welcome toEmployee Payroll App..!!";
    }

    public EmployeePayrollData findById(int id) {
        return repo.findById(id).stream()
                .filter(data -> data.getEmployeeId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found/ Incorrect ID"));
    }

    public EmployeePayrollData create(EmployeePayrollDTO model) {
    	EmployeePayrollData data = new EmployeePayrollData(model);
    	repo.save(data);
        return data;
    }
    
      
    public List<EmployeePayrollData> showAll() {
        return repo.findAll();
    }
    
    public EmployeePayrollData update(int id, EmployeePayrollDTO model) {
    	  EmployeePayrollData employee = this.findById(id);
              employee.setName(model.getName());
              employee.setProfilePic(model.getProfilePic());
              employee.setGender(model.getGender());
              employee.setDepartment(model.getDepartment());
              employee.setSalary(model.getSalary());
              employee.setStartDate(model.getStartDate());
              employee.setNotes(model.getNotes());
              repo.save(employee);
              return employee;                
     }
    
    
    public String delete(int id) {
        EmployeePayrollData data = this.findById(id);
        if(data.equals(data)) {
        	repo.deleteById(id);
        	return "Employee ID : "+id;}
        else
        	return "Incorrect ID";
    }
    
    public List<EmployeePayrollData> getByDepartment(String department) {
        return repo.findByDepartment(department);
    }
}
