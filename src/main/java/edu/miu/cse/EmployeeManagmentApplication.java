package edu.miu.cse;

import edu.miu.cse.model.Employee;
import edu.miu.cse.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class EmployeeManagmentApplication {

    private final EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagmentApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            // Create Employee
            Employee employee = new Employee();
            employee.setFirstName("Abderrahmane");
            employee.setLastName("Seyid");
            employee.setSalary(95000.0);

//            employeeService.addNewEmployee(employee);
            Employee employee1 = new Employee();
            employee1.setFirstName("Mohamed");
            employee1.setLastName("abdou");
            employee1.setSalary(80000.0);
//            employeeService.deleteEmployee(52);
            //Update an Employee object
            Optional<Employee> updatedEmployee = employeeService.updateEmployee(102, employee1);
            employeeService.addNewEmployee(updatedEmployee.get());
        };
    }
}
