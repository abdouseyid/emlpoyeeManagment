package edu.miu.cse.repository;

import edu.miu.cse.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> getEmployeesByEmployeeId(Integer emplloyeeId);
}
