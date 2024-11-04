package edu.miu.cse.service;

import edu.miu.cse.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface EmployeeService {
    Optional<Employee> addNewEmployee(Employee employee);
    Optional<Employee> updateEmployee(Integer employeeId, Employee employee);
    void deleteEmployee(Integer employeeId);
}
