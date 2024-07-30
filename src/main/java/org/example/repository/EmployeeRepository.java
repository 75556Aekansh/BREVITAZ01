package org.example.repository;

import org.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.domain.Pageable;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findAll(Pageable pageable);

    List<Employee> findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(String firstname, String lastname);

    // No need to add any additional methods for basic CRUD operations
}
