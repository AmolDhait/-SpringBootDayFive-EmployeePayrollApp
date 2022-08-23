package com.bridgelabz.employeepayrollapp.exceptions;

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class EmployeePayrollExceptionHandler {
    public ResponseEntity<ResponseDTO> handleMethodArgumentValidException;
            @ExceptionHandler(EmployeePayrollException.class)
            public ResponseEntity<ResponseDTO> handleEmployeePayrollException(
                    EmployeePayrollException exception) {
         ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request",exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
