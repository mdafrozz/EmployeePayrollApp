package com.bridgelabz.employeepayrollapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	
	@Autowired
    EmployeePayrollRepository repo;

    public String getmessage() {
        return "Hello..!! Welcome to Employee Payroll App..!";
    }

    public EmployeePayrollData create(EmployeePayrollDTO data) {
    	EmployeePayrollData model = new EmployeePayrollData(data);
    	repo.save(model);
        return model;
    }
    
    public EmployeePayrollData findById(int id) {
    	Optional<EmployeePayrollData> model  = repo.findById(id);
        return model.get();
    }
    
    public List<EmployeePayrollData> showAll() {
        return repo.findAll();
    }
    
    public EmployeePayrollData update(int id, EmployeePayrollData model) {
    	  EmployeePayrollData employee = repo.getReferenceById(id);
              employee.setName(model.getName());
              employee.setProfileImage(model.getProfileImage());
              employee.setProfileImage(model.getProfileImage());
              employee.setGender(model.getGender());
              employee.setDepartment(model.getDepartment());
              employee.setSalary(model.getSalary());
              employee.setNotes(model.getNotes());
              repo.save(employee);
              return employee;                
     }
    
    
    public String delete(int id) {
        Optional<EmployeePayrollData> employee = repo.findById(id);
        if (employee.isPresent()) {
            repo.delete(employee.get());
            return "Deleted record with id number: " + id;
        } else {
            return "Record not Found";
        }
    }
}
