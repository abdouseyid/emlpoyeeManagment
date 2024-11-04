package edu.miu.cse.service.imp;

import edu.miu.cse.model.Employee;
import edu.miu.cse.repository.EmployeeRepository;
import edu.miu.cse.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> addNewEmployee(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return Optional.of(newEmployee);
    }

    @Override
    public Optional<Employee> updateEmployee(Integer employeeId, Employee employee) {
        Optional<Employee> foundEmployee = employeeRepository.getEmployeesByEmployeeId(employeeId);
        foundEmployee.ifPresent(employee1 -> {
            employee1.setFirstName(employee.getFirstName());
            employee1.setLastName(employee.getLastName());
            employee1.setSalary(employee.getSalary());
        });
//        employeeRepository.save(foundEmployee.get());
        return foundEmployee;
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        employeeRepository.getEmployeesByEmployeeId(employeeId).ifPresent(employee1 -> {
            employeeRepository.delete(employee1);
        });
    }
}
