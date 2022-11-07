package com.delivery.api.service.services;

import com.delivey.db.entities.Employee;
import com.delivey.db.repository.EmployeeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
