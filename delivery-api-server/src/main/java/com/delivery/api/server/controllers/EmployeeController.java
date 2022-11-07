package com.delivery.api.server.controllers;

import com.delivery.api.service.services.EmployeeService;
import com.delivey.db.entities.Employee;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/employee/", produces = "application/json")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }
}
