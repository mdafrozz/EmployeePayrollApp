package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@Autowired
	EmployeePayrollService service;
	
	@RequestMapping(value = {"", "/", "/get"})
    public String getMessage() {
        return service.getmessage();
    }
	
	@PostMapping("/create")
    public EmployeePayrollData getdata(@RequestBody EmployeePayrollData model) {
        EmployeePayrollData model1 = service.create(model);
        return model1;
    }
    
    @GetMapping("/getall")
    public List<EmployeePayrollData> showAll() {
        List<EmployeePayrollData> response = service.showAll();
        return response;
    }
    
	@GetMapping("/get/{id}")
	 public Optional<EmployeePayrollData> findById(@PathVariable int id) {
        Optional<EmployeePayrollData> response = service.findById(id);
        return response;
    }
    
    @PutMapping("/update/{id}") 
    public EmployeePayrollData edit(@RequestBody EmployeePayrollData model, @PathVariable int id) {
        EmployeePayrollData response;
        response = service.update(id, model);
        return response;
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        String response;
        response = service.delete(id);
        return response;
    }

}