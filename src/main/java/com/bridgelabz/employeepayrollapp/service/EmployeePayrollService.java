package com.bridgelabz.employeepayrollapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService {
	
	@Autowired
    EmployeePayrollRepository repo;

    public String getmessage() {
        return "Hello..!! Welcome to Employee Payroll App..!";
    }

    public EmployeePayrollData create(EmployeePayrollData model) {
        repo.save(model);
        return model;
    }
    
    public Optional<EmployeePayrollData> findById(int id) {
        return repo.findById(id);
    }
    public List<EmployeePayrollData> showAll() {
        return repo.findAll();
    }
    
    public EmployeePayrollData update(int id, EmployeePayrollData model) {
        EmployeePayrollData getEmployee = repo.getReferenceById(id);
        getEmployee.setName(model.getName());
        getEmployee.setProfileImage(model.getProfileImage());
        getEmployee.setProfileImage(model.getProfileImage());
        getEmployee.setGender(model.getGender());
        getEmployee.setDepartment(model.getDepartment());
        getEmployee.setSalary(model.getSalary());
        getEmployee.setStartDate(model.getStartDate());
        getEmployee.setNotes(model.getNotes());
        EmployeePayrollData updateEmployee;
        updateEmployee = repo.save(getEmployee);
        return updateEmployee;
    }
    
    public String delete(int id) {
        Optional<EmployeePayrollData> newUser = repo.findById(id);
        if (newUser.isPresent()) {
            repo.delete(newUser.get());
            return "Deleted record with id number: " + id;
        } else {
            return "Record not Found";
        }
    }
}
