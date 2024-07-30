package org.example.controller;

import org.example.exception.ResourseNotFoundException;
import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired private EmployeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(Pageable pageable) {
        Page<Employee> page = employeeRepository.findAll(pageable);
        List<Employee> employees = page.getContent();

        if (employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee =
                employeeRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new ResourseNotFoundException("Employee not found with ID: " + id));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable long id, @RequestBody Employee employeeDetails) {

        Employee updateEmployee =
                employeeRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new ResourseNotFoundException("Employee not found with ID: " + id));

        updateEmployee.setFirstname(employeeDetails.getFirstname());
        updateEmployee.setLastname(employeeDetails.getLastname());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
        Employee employee =
                employeeRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new ResourseNotFoundException("Employee not found with ID: " + id));
        employeeRepository.delete(employee);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String query) {
        return employeeRepository.findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(
                query, query);
    }
}
