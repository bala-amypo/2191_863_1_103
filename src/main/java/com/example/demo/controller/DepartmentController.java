package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@Tag(name = "Departments", description = "Department management operations")
public class DepartmentController {
    
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    @Operation(summary = "Create department", description = "Create a new department in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Department created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid department data")
    })
    public ResponseEntity<Department> create(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.create(department));
    }

    @GetMapping
    @Operation(summary = "Get all departments", description = "Retrieve all departments from the system")
    @ApiResponse(responseCode = "200", description = "List of departments retrieved successfully")
    public ResponseEntity<List<Department>> getAll() {
        return ResponseEntity.ok(departmentService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get department by ID", description = "Retrieve a specific department by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Department found"),
        @ApiResponse(responseCode = "404", description = "Department not found")
    })
    public ResponseEntity<Department> getById(@Parameter(description = "Department ID") @PathVariable Long id) {
        return ResponseEntity.ok(departmentService.get(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update department", description = "Update an existing department's information")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Department updated successfully"),
        @ApiResponse(responseCode = "404", description = "Department not found")
    })
    public ResponseEntity<Department> update(@Parameter(description = "Department ID") @PathVariable Long id, @RequestBody Department department) {
        Department existingDepartment = departmentService.get(id);
        department.setId(id);
        return ResponseEntity.ok(departmentService.create(department));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete department", description = "Remove a department from the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Department deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Department not found")
    })
    public ResponseEntity<String> delete(@Parameter(description = "Department ID") @PathVariable Long id) {
        departmentService.delete(id);
        return ResponseEntity.ok("Department deleted successfully");
    }
}