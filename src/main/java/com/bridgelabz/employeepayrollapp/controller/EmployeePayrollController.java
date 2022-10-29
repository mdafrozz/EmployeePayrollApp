package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@Autowired
	IEmployeePayrollService service;
	
	@RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getMessage() {
		String employee = null;
        employee = service.getmessage();
        ResponseDTO responseDTO = new ResponseDTO("GET Call Success", employee);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
	
	@PostMapping("/create")
    public ResponseEntity<ResponseDTO> getdata(@RequestBody EmployeePayrollDTO model) {
	    EmployeePayrollData data = null;
	    data = service.create(model);
        ResponseDTO responseDTO = new ResponseDTO("Employee added Successfully..!! ", data);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    
    @GetMapping("/getall")
    public List<EmployeePayrollData> showAll() {
        List<EmployeePayrollData> response = service.showAll();
        return response;
    }
    
	@GetMapping("/get/{id}")
	 public ResponseEntity<ResponseDTO> findById(@PathVariable int id) {
		EmployeePayrollData data = null;
        data = service.findById(id);
        ResponseDTO responseDTO = new ResponseDTO("GET Call For Id Successful!!", data);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}") 
    public ResponseEntity<ResponseDTO> edit(@RequestBody EmployeePayrollDTO model, 
    		@PathVariable int id) {
    	EmployeePayrollData data = null;
        data = service.update(id, model);
        ResponseDTO responseDTO = new ResponseDTO("Employee Data Updated Successfully..!!", data);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable int id) {
        String msg = service.delete(id);
        ResponseDTO responseDTO = new ResponseDTO("Employee Removed Successfully..!!", msg );
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
