package com.bridgelabz.employeepayrollapp.service;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

public interface IEmployeePayrollService {

    public String getmessage();
    public EmployeePayrollData create(EmployeePayrollDTO model);
    public EmployeePayrollData findById(int id);
    public List<EmployeePayrollData> showAll();
    public EmployeePayrollData update(int id, EmployeePayrollData model);
    public String delete(int id);
}
