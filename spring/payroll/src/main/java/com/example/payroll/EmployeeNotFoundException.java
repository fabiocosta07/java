package com.example.payroll;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Could Not find Employee="+id);
    }
}
