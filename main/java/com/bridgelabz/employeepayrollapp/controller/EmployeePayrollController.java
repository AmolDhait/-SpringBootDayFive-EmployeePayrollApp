package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")

public class EmployeePayrollController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @RequestMapping(value = {"","/","/get" })
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<EmployeePayrollData> empDataList;
        empDataList = iEmployeeService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", empDataList);
    return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK );
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
        EmployeePayrollData employeePayrollData;
        employeePayrollData = iEmployeeService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful", employeePayrollData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData employeePayrollData;
        employeePayrollData = iEmployeeService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO =new ResponseDTO("Create Employee Payroll Data Successfully", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(@PathVariable("empId") int empId,
                                                             @RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData employeePayrollData;
        employeePayrollData = iEmployeeService.updateEmployeePayrollData(empId, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Successfully", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Delete id:" +empId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
