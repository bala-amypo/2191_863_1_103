package com.example.demo.controller;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.service.AvailabilityService;
import com.example.demo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/availability")
@Tag(name = "Employee Availability", description = "Employee availability operations")
public class AvailabilityController {
    
    private final AvailabilityService availabilityService;
    private final EmployeeService employeeService;

    public AvailabilityController(AvailabilityService availabilityService, EmployeeService employeeService) {
        this.availabilityService = availabilityService;
        this.employeeService = employeeService;
    }

    @PostMapping("/{employeeId}")
    @Operation(summary = "Create availability", description = "Create availability record for an employee")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Availability created successfully"),
        @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    public ResponseEntity<EmployeeAvailability> create(@Parameter(description = "Employee ID") @PathVariable Long employeeId, @RequestBody EmployeeAvailability availability) {
        availability.setEmployee(employeeService.getEmployee(employeeId));
        return ResponseEntity.ok(availabilityService.create(availability));
    }

    @GetMapping("/employee/{employeeId}")
    @Operation(summary = "Get availability by employee", description = "Retrieve all availability records for a specific employee")
    @ApiResponse(responseCode = "200", description = "Availability records retrieved successfully")
    public ResponseEntity<List<EmployeeAvailability>> getByEmployee(@Parameter(description = "Employee ID") @PathVariable Long employeeId) {
        return ResponseEntity.ok(availabilityService.getByEmployee(employeeId));
    }

    @GetMapping("/{availabilityId}")
    @Operation(summary = "Get availability by ID", description = "Retrieve a specific availability record by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Availability record found"),
        @ApiResponse(responseCode = "404", description = "Availability record not found")
    })
    public ResponseEntity<EmployeeAvailability> getById(@Parameter(description = "Availability ID") @PathVariable Long availabilityId) {
        return ResponseEntity.ok(availabilityService.getById(availabilityId));
    }

    @GetMapping("/date/{date}")
    @Operation(summary = "Get availability by date", description = "Retrieve all availability records for a specific date")
    @ApiResponse(responseCode = "200", description = "Availability records for date retrieved successfully")
    public ResponseEntity<List<EmployeeAvailability>> getByDate(@Parameter(description = "Date (YYYY-MM-DD)") @PathVariable LocalDate date) {
        return ResponseEntity.ok(availabilityService.getByDate(date));
    }
}