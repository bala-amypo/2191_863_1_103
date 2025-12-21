package com.example.demo.controller;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.dto.AvailabilityDto;
import com.example.demo.service.AvailabilityService;
import com.example.demo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/availability")
@Tag(name = "Employee Availability", description = "Employee Availability Endpoints")
public class AvailabilityController {
    
    private final AvailabilityService availabilityService;
    private final EmployeeService employeeService;

    public AvailabilityController(AvailabilityService availabilityService, EmployeeService employeeService) {
        this.availabilityService = availabilityService;
        this.employeeService = employeeService;
    }

    @PostMapping("/{employeeId}")
    @Operation(summary = "Set availability for employee")
    public ResponseEntity<EmployeeAvailability> create(@PathVariable Long employeeId, @RequestBody AvailabilityDto dto) {
        EmployeeAvailability availability = new EmployeeAvailability();
        availability.setEmployee(employeeService.getEmployee(employeeId));
        availability.setAvailableDate(dto.getAvailableDate());
        availability.setAvailable(dto.getAvailable());
        return ResponseEntity.ok(availabilityService.create(availability));
    }

    @GetMapping("/employee/{employeeId}")
    @Operation(summary = "Get availability records for employee")
    public ResponseEntity<List<EmployeeAvailability>> getByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(availabilityService.getByEmployee(employeeId));
    }

    @GetMapping("/{availabilityId}")
    @Operation(summary = "Get specific availability record")
    public ResponseEntity<EmployeeAvailability> getById(@PathVariable Long availabilityId) {
        return ResponseEntity.ok(availabilityService.getById(availabilityId));
    }

    @GetMapping("/date/{date}")
    @Operation(summary = "Get availability records for date")
    public ResponseEntity<List<EmployeeAvailability>> getByDate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(availabilityService.getByDate(date));
    }
}