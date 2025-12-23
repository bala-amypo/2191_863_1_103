package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employees", description = "Employee management operations")
public class EmployeeController {
    
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    @Operation(summary = "Create new employee", description = "Register a new employee in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Employee created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid employee data")
    })
    public ResponseEntity<Employee> register(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @GetMapping("/all")
    @Operation(summary = "Get all employees", description = "Retrieve all employees from the system")
    @ApiResponse(responseCode = "200", description = "List of employees retrieved successfully")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get employee by ID", description = "Retrieve a specific employee by their ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Employee found"),
        @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    public ResponseEntity<Employee> getById(@Parameter(description = "Employee ID") @PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update employee", description = "Update an existing employee's information")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Employee updated successfully"),
        @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    public ResponseEntity<Employee> update(@Parameter(description = "Employee ID") @PathVariable Long id, @RequestBody Employee employee) {
        Employee existingEmployee = employeeService.getEmployee(id);
        employee.setId(id);
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete employee", description = "Remove an employee from the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Employee deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    public ResponseEntity<String> delete(@Parameter(description = "Employee ID") @PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}